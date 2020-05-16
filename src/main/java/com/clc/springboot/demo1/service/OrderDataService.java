package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.entities.OrderData;
import com.clc.springboot.demo1.facade.vo.OrderDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDataService {

    List<OrderDataVo> findOrderDataByYearAndMonth();

    List<Long> findTotalDishNumberByYearAndMonth();

    List<Float> findTotalOrderPriceByYearAndMonth();

    List<Float> findAverageOrderPriceByYearAndMonth();

}
