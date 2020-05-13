package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.so.OrderSo;
import com.clc.springboot.demo1.facade.vo.OrderVo;

import java.util.List;

public interface OrderService {

    Boolean createOrder(String remark, Long deliveryId, Long userId);

    Boolean updateOrderEvaluate(String evaluate, Long id);

    Boolean updateOrderStatus(String status, Long id);

    List<OrderVo> findAllOrderByUserId(String status, Long userId);

    List<OrderVo> findAllOrder(String status);

}
