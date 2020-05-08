package com.clc.springboot.demo1.service;

import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.UserSo;
import com.clc.springboot.demo1.facade.vo.UserVo;

import java.util.List;

public interface UserService {

    List<UserVo> showUserList(UserSo userSo);

    User login(UserSo userSo);

    Boolean changePassword(UserSo userSo, Long id);

    Boolean changeData(UserSo userSo, Long id);

//    Boolean updateBalance(Float balance, Long id);

}
