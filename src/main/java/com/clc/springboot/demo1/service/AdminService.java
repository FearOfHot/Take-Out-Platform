package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.facade.so.AdminSo;

public interface AdminService {

    Admin login(AdminSo adminSo);

    Boolean changePassword(AdminSo adminSo, Long id);

    Boolean changeData(AdminSo adminSo, Long id);

}
