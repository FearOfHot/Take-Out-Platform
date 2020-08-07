package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.base.AlipayBean;
import com.clc.springboot.demo1.service.PayService;
import com.clc.springboot.demo1.support.utilities.Alipay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}

