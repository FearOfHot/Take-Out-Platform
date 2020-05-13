package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.Cart;
import com.clc.springboot.demo1.facade.entities.Dish;
import com.clc.springboot.demo1.facade.so.CartSo;
import com.clc.springboot.demo1.facade.vo.CartVo;
import com.clc.springboot.demo1.facade.vo.DishVo;
import com.clc.springboot.demo1.mapper.CartMapper;
import com.clc.springboot.demo1.mapper.DishMapper;
import com.clc.springboot.demo1.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private DishMapper dishMapper;

    @Override
    @Transactional
    public Boolean saveCart(CartSo cartSo, Long userId) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartSo, cart);
        cart.setUserId(userId);
//        Dish dish = dishMapper.findDishById(cart.getDishId());
//        cart.setPrice(dish.getPrice() * cart.getDishNumber());
        cartMapper.insertSelective(cart);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateDishNumber(Long changeNumber, Long dishId, Long userId) {
        if (changeNumber == 0) {
            cartMapper.deleteDishInCart(dishId, userId);
        } else {
            cartMapper.updateDishNumber(changeNumber, dishId, userId);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateDishOneNumber(Long oneNumber, Long dishId, Long userId) {
        CartVo cartVo = cartMapper.findDishInCartByDishId(dishId, userId);
        if ((oneNumber == -1) && (cartVo.getDishNumber() == 1)) {
            cartMapper.deleteDishInCart(dishId, userId);
        } else {
            cartMapper.updateDishOneNumber(oneNumber, dishId, userId);
        }
        return true;
    }

    @Override
    @Transactional
    public List<CartVo> findAllDishByUserId(Long userId) {
        return cartMapper.findAllDishByUserId(userId);
    }

    @Override
    @Transactional
    public Boolean deleteDishInCart(Long dishId, Long userId) {
        cartMapper.deleteDishInCart(dishId, userId);
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteAllDishByUserId(Long userId) {
        cartMapper.deleteAllDishByUserId(userId);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateCartPrice(Long userId) {
        List<CartVo> cartVoList = cartMapper.findAllDishByUserId(userId);
        for (CartVo cartVo : cartVoList) {
            DishVo dishVo = dishMapper.findDishById(cartVo.getDishId());
            Float singlePrice = dishVo.getPrice();
            Long number = cartVo.getDishNumber();
            Float totalPrice = singlePrice * number;
            cartMapper.updateCartPrice(totalPrice, cartVo.getDishId(), userId);
        }

        return true;
    }
}
