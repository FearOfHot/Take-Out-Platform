package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.so.CartSo;
import com.clc.springboot.demo1.facade.vo.CartVo;

import java.util.List;

public interface CartService {

    Boolean saveCart(CartSo cartSo, Long userId);

    Boolean updateDishNumber(Long changeNumber, Long dishId, Long userId);

    Boolean updateDishOneNumber(Long oneNumber, Long dishId, Long userId);

    List<CartVo> findAllDishByUserId(Long userId);

    Boolean deleteDishInCart(Long dishId, Long userId);

    Boolean deleteAllDishByUserId(Long userId);

    Boolean updateCartPrice(Long userId);

}
