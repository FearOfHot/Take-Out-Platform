package com.clc.springboot.demo1.service;

import com.alipay.api.AlipayApiException;
import com.clc.springboot.demo1.facade.base.AlipayBean;

/**
 * 支付服务
 */
public interface PayService {

    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}

