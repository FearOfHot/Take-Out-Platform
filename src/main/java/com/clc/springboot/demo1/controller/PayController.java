package com.clc.springboot.demo1.controller;

import com.alipay.api.AlipayApiException;
import com.clc.springboot.demo1.facade.base.AlipayBean;
import com.clc.springboot.demo1.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 支付宝沙箱测试
 */
@RestController
@RequestMapping("alipay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "payment", produces = "text/html;charset=UTF-8")
    public String alipay(@RequestBody AlipayBean alipayBean) throws AlipayApiException {
        return payService.aliPay(alipayBean);
    }

}

