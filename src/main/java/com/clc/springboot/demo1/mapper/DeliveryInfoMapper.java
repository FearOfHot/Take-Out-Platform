package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.DeliveryInfo;
import com.clc.springboot.demo1.facade.vo.DeliveryInfoVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryInfoMapper extends MapperAdapter<DeliveryInfo> {

    List<DeliveryInfoVo> findAllDeliveryInfo(@Param("userId") Long userId);

    DeliveryInfoVo findDeliveryInfoById(@Param("id") Long id, @Param("userId") Long userId);

}
