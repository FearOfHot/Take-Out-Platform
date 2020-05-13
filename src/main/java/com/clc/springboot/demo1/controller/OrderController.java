package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.entities.Order;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.OrderSo;
import com.clc.springboot.demo1.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    /**
     * 生成订单
     * @param orderSo
     * @return
     */
    @PostMapping("create")
    public Message createOrder(@RequestBody OrderSo orderSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(orderService.createOrder(orderSo.getRemark(), orderSo.getDeliveryId(), user.getId()));
    }

    /**
     * 添加用户的评价
     * @param orderSo
     * @return
     */
    @PostMapping("/evaluate/update")
    public Message updateOrderEvaluate(@RequestBody OrderSo orderSo) {
        return new Message().setObj(orderService.updateOrderEvaluate(orderSo.getEvaluate(), orderSo.getId()));
    }

    /**
     * 修改订单的状态
     * @param orderSo
     * @return
     */
    @PostMapping("/status/update")
    public Message updateOrderStatus(@RequestBody OrderSo orderSo) {
        return new Message().setObj(orderService.updateOrderStatus(orderSo.getStatus(), orderSo.getId()));
    }

    /**
     * 查询用户的所有订单
     * @return
     */
    @PostMapping("query")
    public Message findAllOrderByUserId(@RequestBody OrderSo orderSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(orderService.findAllOrderByUserId(orderSo.getStatus(), user.getId()));
    }

    /**
     * 查询所有用户的所有订单
     * @return
     */
    @PostMapping("/all/query")
    public Message findAllOrder(@RequestBody OrderSo orderSo) {
        return new Message().setObj(orderService.findAllOrder(orderSo.getStatus()));
    }

}
