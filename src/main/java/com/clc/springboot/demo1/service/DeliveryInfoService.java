package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.so.DeliveryInfoSo;
import com.clc.springboot.demo1.facade.vo.DeliveryInfoVo;

import java.util.List;

public interface DeliveryInfoService {

    List<DeliveryInfoVo> findAllDeliveryInfo(Long userId);

    Boolean saveDeliveryInfo(DeliveryInfoSo deliveryInfoSo, Long userId);

    Boolean deleteDeliveryInfo(DeliveryInfoSo deliveryInfoSo);

}
