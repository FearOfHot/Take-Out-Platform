package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.service.OrderDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("data")
public class DataStatisticsController {

    @Resource
    private OrderDataService orderDataService;

    @PostMapping("order")
    public Message findOrderDataByYearAndMonth() {
        return new Message().setObj(orderDataService.findOrderDataByYearAndMonth());
    }

    @PostMapping("dish/number")
    public Message findTotalDishNumberByYearAndMonth() {
        return new Message().setObj(orderDataService.findTotalDishNumberByYearAndMonth());
    }

    @PostMapping("order/total/price")
    public Message findTotalOrderPriceByYearAndMonth() {
        return new Message().setObj(orderDataService.findTotalOrderPriceByYearAndMonth());
    }

    @PostMapping("/order/average/price")
    public Message findAverageOrderPriceByYearAndMonth() {
        return new Message().setObj(orderDataService.findAverageOrderPriceByYearAndMonth());
    }

}
