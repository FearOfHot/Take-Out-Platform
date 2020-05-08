package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.Cart;
import com.clc.springboot.demo1.facade.vo.CartVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper extends MapperAdapter<Cart> {

    CartVo findDishInCartByDishId(@Param("dishId") Long dishId, @Param("userId") Long userId);

    Boolean updateDishNumber(@Param("changeNumber") Long changeNumber, @Param("dishId") Long dishId, @Param("userId") Long userId);

    Boolean updateDishOneNumber(@Param("oneNumber") Long oneNumber, @Param("dishId") Long dishId, @Param("userId") Long userId);

    Boolean deleteDishInCart(@Param("dishId") Long dishId, @Param("userId") Long userId);

    List<CartVo> findAllDishByUserId(@Param("userId") Long userId);

    Boolean deleteAllDishByUserId(@Param("userId") Long userId);

    Boolean updateCartPrice(@Param("price") Float price, @Param("dishId") Long dishId, @Param("userId") Long userId);

}
