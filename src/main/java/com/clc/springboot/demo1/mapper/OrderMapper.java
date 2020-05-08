package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.Order;
import com.clc.springboot.demo1.facade.vo.OrderVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper extends MapperAdapter<Order> {

    OrderVo findOrderById(@Param("id") Long id);

    OrderVo findOrderByNumber(@Param("number") String order);

    Boolean updateOrderEvaluate(@Param("evaluate") String evaluate, @Param("id") Long id);

    Boolean updateOrderStatus(@Param("status") String status, @Param("id") Long id);

    List<OrderVo> findAllOrderByUserId(@Param("status") String status, @Param("userId") Long userId);

    List<OrderVo> findAllOrder(@Param("status") String status);

    Boolean insertOrder(@Param("userId") Long userId, @Param("number") String number, @Param("price") Float price, @Param("remark") String remark);

}
