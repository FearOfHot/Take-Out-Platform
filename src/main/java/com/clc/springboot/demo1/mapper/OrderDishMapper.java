package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.OrderDish;
import com.clc.springboot.demo1.facade.vo.OrderDishVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDishMapper extends MapperAdapter<OrderDish> {

    List<OrderDishVo> findOrderDishByOrderId(@Param("orderId") Long orderId);

}
