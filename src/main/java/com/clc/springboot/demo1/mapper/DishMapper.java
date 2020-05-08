package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.Dish;
import com.clc.springboot.demo1.facade.vo.DishVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishMapper extends MapperAdapter<Dish> {

    List<DishVo> findAllDish();

    Dish findDishById(@Param("id") Long id);

    Boolean updateSalesVolume(@Param("salesVolume") Long salesVolume, @Param("id") Long id);

}
