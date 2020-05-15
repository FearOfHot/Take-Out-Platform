package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.UserSo;
import com.clc.springboot.demo1.facade.vo.OrderVo;
import com.clc.springboot.demo1.facade.vo.UserVo;
import com.clc.springboot.demo1.mapper.OrderMapper;
import com.clc.springboot.demo1.mapper.UserMapper;
import com.clc.springboot.demo1.service.UserService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import com.clc.springboot.demo1.support.utilities.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public List<UserVo> showUserList(UserSo userSo) {
        List<UserVo> resultList = new ArrayList<>();
        String phoneNumber = userSo.getPhoneNumber();
        if (ParamUtil.isNotEmpty(userSo.getName())) {
            //特殊字符转义
            String name = userSo.getName();
            if (name.contains("_") || name.contains("%") || name.contains("\\")) {
                name = StringUtil.getSqlLikeSearch(name);
            }
            resultList = userMapper.showUserList(name, phoneNumber);
        } else {
            resultList = userMapper.showUserList(userSo.getName(), phoneNumber);
        }
        return resultList;
    }

    @Override
    @Transactional
    public User login(UserSo userSo) {
        return userMapper.findUserByNumberAndPassword(userSo.getNumber(), userSo.getPassword());
    }

    @Override
    @Transactional
    public Boolean changePassword(UserSo userSo, Long id) {
        userMapper.changePassword(userSo.getPassword(), id);
        return true;
    }

    @Override
    @Transactional
    public Boolean changeData(UserSo userSo, Long id) {
        User user = new User();
        BeanUtils.copyProperties(userSo, user);
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

//    @Override
//    @Transactional
//    public Boolean updateBalance(Float balance, Long id) {
//        List<OrderVo> orderVoList = orderMapper.findAllOrderByUserId(id);
//        return true;
//    }

    private User userVoToUser(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setNumber(userVo.getNumber());
        user.setName(userVo.getName());
        user.setPassword(userVo.getPassword());
        user.setAddress(userVo.getAddress());
        user.setSex(userVo.getSex());
        user.setBalance(userVo.getBalance());
        user.setPhoneNumber(userVo.getPhoneNumber());
        return user;
    }

    @Override
    @Transactional
    public User getInfo(Long id) {
        return userMapper.findUserById(id);
    }
}
