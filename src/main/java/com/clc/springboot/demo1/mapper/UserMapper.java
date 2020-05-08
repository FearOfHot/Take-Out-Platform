package com.clc.springboot.demo1.mapper;

import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.vo.UserVo;
import com.clc.springboot.demo1.support.adapter.MapperAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper extends MapperAdapter<User> {

    /**
     * 查询学生列表
     * @param name
     * @param phoneNumber
     * @return
     */
    List<UserVo> showUserList(@Param("name") String name, @Param("phoneNumber") String phoneNumber);

    User findUserByNumberAndPassword(@Param("number") String number, @Param("password") String password);

    void changePassword(@Param("password") String password, @Param("id") Long id);

//    void changeData(@Param("name") String name, @Param("sex") String sex, @Param("phoneNumber") String phoneNumber, @Param("address") String address, @Param("id") Long id);

    User findUserById(@Param("id") Long id);

    Boolean updateBalance(@Param("balance") Float balance, @Param("id") Long id);

}
