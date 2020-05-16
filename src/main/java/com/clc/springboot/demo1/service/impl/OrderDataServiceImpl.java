package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.vo.OrderDataVo;
import com.clc.springboot.demo1.facade.vo.OrderDishVo;
import com.clc.springboot.demo1.facade.vo.OrderVo;
import com.clc.springboot.demo1.mapper.OrderDataMapper;
import com.clc.springboot.demo1.mapper.OrderDishMapper;
import com.clc.springboot.demo1.mapper.OrderMapper;
import com.clc.springboot.demo1.service.OrderDataService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {

    @Resource
    private OrderDataMapper orderDataMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDishMapper orderDishMapper;

    @Override
    @Transactional
    public List<OrderDataVo> findOrderDataByYearAndMonth() {
        List<OrderDataVo> orderDataVoList = new ArrayList<>();
        // 获取当前年份
        Calendar calendar = Calendar.getInstance();
        Long thisYear = Long.parseLong(calendar.get(Calendar.YEAR) + "");
        for (Long month = 1L; month < 13L; month++) {
            OrderDataVo orderDataVo = orderDataMapper.findOrderDataByYearAndMonth(thisYear, month);
            List<OrderVo> orderVoList = orderMapper.findOrderByYearAndMonth(thisYear, month);
            Long dishTotalNumber = 0L;
            if (ParamUtil.isNotEmpty(orderVoList)) {
                for (OrderVo orderVo : orderVoList) {
                    List<OrderDishVo> orderDishVoList = orderDishMapper.findOrderDishByOrderId(orderVo.getId());
                    for (OrderDishVo orderDishVo : orderDishVoList) {
                        dishTotalNumber += orderDishVo.getDishNumber();
                    }
                }
            }
            orderDataVo.setOrderTotalDishNumber(dishTotalNumber);
            orderDataVo.setYear(thisYear);
            orderDataVo.setMonth(month);
            orderDataVoList.add(orderDataVo);
        }
        return orderDataVoList;
    }

    @Override
    @Transactional
    public List<Long> findTotalDishNumberByYearAndMonth() {
        // 获取当前年份
        Calendar calendar = Calendar.getInstance();
        Long thisYear = Long.parseLong(calendar.get(Calendar.YEAR) + "");
        List<Long> totalDishNumberList = new ArrayList<>();
        for (Long month = 1L; month < 13L; month++) {
            List<OrderVo> orderVoList = orderMapper.findOrderByYearAndMonth(thisYear, month);
            Long dishTotalNumber = 0L;
            if (ParamUtil.isNotEmpty(orderVoList)) {
                for (OrderVo orderVo : orderVoList) {
                    List<OrderDishVo> orderDishVoList = orderDishMapper.findOrderDishByOrderId(orderVo.getId());
                    for (OrderDishVo orderDishVo : orderDishVoList) {
                        dishTotalNumber += orderDishVo.getDishNumber();
                    }
                }
            }
            totalDishNumberList.add(dishTotalNumber);
        }
        return totalDishNumberList;
    }

    @Override
    public List<Float> findTotalOrderPriceByYearAndMonth() {
        // 获取当前年份
        Calendar calendar = Calendar.getInstance();
        Long thisYear = Long.parseLong(calendar.get(Calendar.YEAR) + "");
        List<Float> totalOrderPriceList = new ArrayList<>();
        for (Long month = 1L; month < 13L; month++) {
            OrderDataVo orderDataVo = orderDataMapper.findOrderDataByYearAndMonth(thisYear, month);
            if (ParamUtil.isNotEmpty(orderDataVo.getOrderTotalPrice())) {
                totalOrderPriceList.add(orderDataVo.getOrderTotalPrice());
            } else {
                totalOrderPriceList.add(0.0F);
            }
        }
        return totalOrderPriceList;
    }

    @Override
    public List<Float> findAverageOrderPriceByYearAndMonth() {
        // 获取当前年份
        Calendar calendar = Calendar.getInstance();
        Long thisYear = Long.parseLong(calendar.get(Calendar.YEAR) + "");
        List<Float> averageOrderPriceList = new ArrayList<>();
        for (Long month = 1L; month < 13L; month++) {
            OrderDataVo orderDataVo = orderDataMapper.findOrderDataByYearAndMonth(thisYear, month);
            if (ParamUtil.isNotEmpty(orderDataVo.getOrderAvgPrice())) {
                averageOrderPriceList.add(orderDataVo.getOrderAvgPrice());
            } else {
                averageOrderPriceList.add(0.0F);
            }
        }
        return averageOrderPriceList;
    }
}
