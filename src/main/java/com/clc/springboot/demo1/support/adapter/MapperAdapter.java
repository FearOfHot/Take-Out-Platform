package com.clc.springboot.demo1.support.adapter;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;


public interface MapperAdapter<T> extends Mapper<T> {
    @UpdateProvider(
            type = MapperProvider.class,
            method = "dynamicSQL"
    )
    int updateByPrimaryKeyProperty(@Param("entity") T entity, @Param("property") Collection<String> property);

    @UpdateProvider(
            type = MapperProvider.class,
            method = "dynamicSQL"
    )
    int updatePropertyByPrimaryKey(@Param("entity") T entity, @Param("property") Collection<String> property);

}
