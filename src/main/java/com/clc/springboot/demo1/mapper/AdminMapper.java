package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends MapperAdapter<Admin> {

    Admin findAdminByNumberAndPassword(@Param("username") String username, @Param("password") String password);

    void changePassword(@Param("password") String password, @Param("id") Long id);

    Admin findAdminById(@Param("id") Long id);

}
