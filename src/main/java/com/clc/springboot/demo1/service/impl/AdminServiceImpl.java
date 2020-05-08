package com.clc.springboot.demo1.service.impl;


import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.facade.so.AdminSo;
import com.clc.springboot.demo1.mapper.AdminMapper;
import com.clc.springboot.demo1.service.AdminService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    @Transactional
    public Admin login(AdminSo adminSo) {
        return adminMapper.findAdminByNumberAndPassword(adminSo.getUsername(), adminSo.getPassword());
    }

    @Override
    @Transactional
    public Boolean changePassword(AdminSo adminSo, Long id) {
        adminMapper.changePassword(adminSo.getPassword(), id);
        return true;
    }

    @Override
    @Transactional
    public Boolean changeData(AdminSo adminSo, Long id) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminSo, admin);
        admin.setId(id);
        adminMapper.updateByPrimaryKeySelective(admin);
        return true;
    }
}
