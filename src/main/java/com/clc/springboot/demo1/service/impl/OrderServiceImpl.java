package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.*;
import com.clc.springboot.demo1.facade.enums.exception.ExceptionTypeEnum;
import com.clc.springboot.demo1.facade.so.OrderSo;
import com.clc.springboot.demo1.facade.vo.*;
import com.clc.springboot.demo1.mapper.*;
import com.clc.springboot.demo1.service.OrderService;
import com.clc.springboot.demo1.support.excepts.ServiceEx;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private OrderDishMapper orderDishMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DishMapper dishMapper;

    @Resource
    private DeliveryInfoMapper deliveryInfoMapper;

    @Override
    @Transactional
    public Boolean createOrder(String remark, Long deliveryId, Long userId) {
        Order order = new Order();
        // 自动根据当前时间及学生学号生成订单号
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String number = format.format(date).replace("-","") + userId;
        List<CartVo> cartVoList = cartMapper.findAllDishByUserId(userId);
        if (cartVoList.size() == 0) {
            throw new ServiceEx(ExceptionTypeEnum.UNKNOWN_EXCEPTION);
        }
        Float price = 0f;
        for (CartVo cartVo : cartVoList) {
            price += cartVo.getPrice();
        }
        DeliveryInfoVo deliveryInfoVo = deliveryInfoMapper.findDeliveryInfoById(deliveryId, userId);
        order.setName(deliveryInfoVo.getName());
        order.setAddress(deliveryInfoVo.getSchool() + deliveryInfoVo.getRegion() + deliveryInfoVo.getAddress());
        order.setPhone(deliveryInfoVo.getPhone());
        order.setUserId(userId);
        order.setNumber(number);
        order.setPrice(price);
        if (ParamUtil.isNotEmpty(remark)) {
            order.setRemark(remark);
        }
        // 由于order是数据库中的关键字，在使用mybatis的插入语句时报错
        // orderMapper.insertSelective(order);
        orderMapper.insertOrder(order.getUserId(), order.getNumber(),order.getName(), order.getAddress(), order.getPhone(), order.getPrice(), order.getRemark());
        // 在订单表中新增订单完毕后获取该订单
        OrderVo orderVo = orderMapper.findOrderByNumber(number);
        // 在订单菜品映射表中添加映射关系
        for (CartVo cartVo : cartVoList) {
            OrderDish orderDish = new OrderDish();
            orderDish.setOrderId(orderVo.getId());
            orderDish.setDishId(cartVo.getDishId());
            orderDish.setDishNumber(cartVo.getDishNumber());
            orderDish.setPrice(cartVo.getPrice());
            orderDishMapper.insertSelective(orderDish);
        }
        List<OrderDishVo> orderDishVoList = orderDishMapper.findOrderDishByOrderId(orderVo.getId());
        for (OrderDishVo orderDishVo : orderDishVoList) {
            DishVo dishVo = dishMapper.findDishById(orderDishVo.getDishId());
            dishVo.setSalesVolume(dishVo.getSalesVolume() + orderDishVo.getDishNumber());
            dishMapper.updateSalesVolume(dishVo.getSalesVolume(), dishVo.getId());
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateOrderEvaluate(String evaluate, Long id) {
        if (ParamUtil.isNullOrEmpty(evaluate)) {
            throw new ServiceEx(ExceptionTypeEnum.PARAM_NULL_EXCEPTION);
        }
        orderMapper.updateOrderEvaluate(evaluate, id);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateOrderStatus(String status, Long id) {
        if ("1".equals(status)) {
            // 订单状态变更为已支付时，扣除用户的余额
            OrderVo orderVo = orderMapper.findOrderById(id);
            User user = userMapper.findUserById(orderVo.getUserId());
            userMapper.updateBalance((user.getBalance() - orderVo.getPrice()), user.getId());
        }
        if ("-1".equals(status)) {
            // 订单状态变更为无效，即表示取消订单，将菜品的销量变更回去
            List<OrderDishVo> orderDishVoList = orderDishMapper.findOrderDishByOrderId(id);
            for (OrderDishVo orderDishVo : orderDishVoList) {
                DishVo dishVo = dishMapper.findDishById(orderDishVo.getDishId());
                dishVo.setSalesVolume(dishVo.getSalesVolume() - orderDishVo.getDishNumber());
                dishMapper.updateSalesVolume(dishVo.getSalesVolume(), dishVo.getId());
            }
        }
        orderMapper.updateOrderStatus(status, id);
        return true;
    }

    @Override
    @Transactional
    public List<OrderVo> findAllOrderByUserId(String status, Long userId) {
        List<OrderVo> orderVoList = orderMapper.findAllOrderByUserId(status, userId);
        setOrderDishList(orderVoList);
        return orderVoList;
    }

    @Override
    @Transactional
    public List<OrderVo> findAllOrder(String status) {
        List<OrderVo> orderVoList = orderMapper.findAllOrder(status);
        setOrderDishList(orderVoList);
        return orderVoList;
    }

    /**
     * 设置订单列表中所有订单的菜品列表
     * @param orderVoList
     */
    private void setOrderDishList(List<OrderVo> orderVoList) {
        for (OrderVo orderVo : orderVoList) {
            Long orderId = orderVo.getId();
            // 获取订单-菜品映射关系对象列表
            List<OrderDishVo> orderDishVoList = orderDishMapper.findOrderDishByOrderId(orderId);
            List<DishVo> dishVoList = new ArrayList<>();
            for (OrderDishVo orderDishVo : orderDishVoList) {
                Long dishId = orderDishVo.getDishId();
                DishVo dishVo = dishMapper.findDishById(dishId);
                dishVoList.add(dishVo);
            }
            orderVo.setDishVoList(dishVoList);
        }
    }

}
