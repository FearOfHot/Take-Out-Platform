package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.OrderData;
import com.clc.springboot.demo1.facade.vo.OrderDataVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

public interface OrderDataMapper extends MapperAdapter<OrderData> {

    OrderDataVo findOrderDataByYearAndMonth(@Param("year") Long year, @Param("month") Long month);

}
