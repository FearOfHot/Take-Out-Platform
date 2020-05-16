package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.Dish;
import com.clc.springboot.demo1.facade.so.DishSo;
import com.clc.springboot.demo1.facade.vo.CartVo;
import com.clc.springboot.demo1.facade.vo.DishVo;
import com.clc.springboot.demo1.facade.vo.UserVo;
import com.clc.springboot.demo1.mapper.CartMapper;
import com.clc.springboot.demo1.mapper.DishMapper;
import com.clc.springboot.demo1.mapper.OrderMapper;
import com.clc.springboot.demo1.service.DishService;
import com.clc.springboot.demo1.support.utilities.ImageToBASE64;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Resource
    private DishMapper dishMapper;

    @Resource
    private CartMapper cartMapper;

    @Override
    @Transactional
    public List<DishVo> findAllDishAndWhetherInCart(Long userId) {
        //先查询到数据库中所有的菜品
        List<DishVo> dishVoList = dishMapper.findAllDish();
        //再根据用户的id查询到用户的购物车
        List<CartVo> cartVoList = cartMapper.findAllDishByUserId(userId);

        for (DishVo dishVo : dishVoList) {
            if (ParamUtil.isNotEmpty(cartVoList)) {
                for (CartVo cartVo : cartVoList) {
                    if (dishVo.getId().equals(cartVo.getDishId())) {
                        dishVo.setInCurrentUserCartOrNot(true);
                        dishVo.setInCurrentUserCartDishNumber(cartVo.getDishNumber());
                        //当查询到购物车中有菜品与菜单中对应时，将其移出该购物车列表，使得不会重复设置boolean值
                        cartVoList.remove(cartVo);
                        //同时跳出购物车循环体
                        break;
                    }
                }
            }
        }
        return dishVoList;
    }

    @Override
    @Transactional
    public List<DishVo> findAllDish() {
        List<DishVo> dishVoList = dishMapper.findAllDish();
        for (DishVo dishVo : dishVoList) {
            if (ParamUtil.isNotEmpty(dishVo.getUrl())) {
                try {
                    dishVo.setBase64Url(ImageToBASE64.ImageToBase64ByLocal(dishVo.getUrl().substring(21)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return dishVoList;
    }

    @Override
    @Transactional
    public Boolean saveDish(DishSo dishSo) {
        //创建一个新的菜品
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishSo, dish);
        if (ParamUtil.isNotEmpty(dishSo.getId())) {
            //表示编辑菜品
            dishMapper.updateByPrimaryKeySelective(dish);
        } else {
            //表示新建菜品
            dishMapper.insertSelective(dish);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteDish(DishSo dishSo) {
        dishMapper.deleteByPrimaryKey(dishSo.getId());
        return true;
    }
}
