package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.DeliveryInfo;
import com.clc.springboot.demo1.facade.so.DeliveryInfoSo;
import com.clc.springboot.demo1.facade.vo.DeliveryInfoVo;
import com.clc.springboot.demo1.mapper.DeliveryInfoMapper;
import com.clc.springboot.demo1.service.DeliveryInfoService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

    @Resource
    private DeliveryInfoMapper deliveryInfoMapper;

    @Override
    @Transactional
    public List<DeliveryInfoVo> findAllDeliveryInfo(Long userId) {
        return deliveryInfoMapper.findAllDeliveryInfo(userId);
    }

    @Override
    @Transactional
    public Boolean saveDeliveryInfo(DeliveryInfoSo deliveryInfoSo, Long userId) {
        //创建一个新的信息
        DeliveryInfo info = new DeliveryInfo();
        BeanUtils.copyProperties(deliveryInfoSo, info);
        if (ParamUtil.isNotEmpty(deliveryInfoSo.getId())) {
            //表示编辑信息
            deliveryInfoMapper.updateByPrimaryKeySelective(info);
        } else {
            //表示新建信息
            info.setUserId(userId);
            deliveryInfoMapper.insertSelective(info);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteDeliveryInfo(DeliveryInfoSo deliveryInfoSo) {
        deliveryInfoMapper.deleteByPrimaryKey(deliveryInfoSo.getId());
        return true;
    }
}
