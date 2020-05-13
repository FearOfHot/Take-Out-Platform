package com.clc.springboot.demo1.controller;


import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.UserSo;
import com.clc.springboot.demo1.service.UserService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("list")
    public Message showUserList(@RequestBody UserSo userSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(userService.showUserList(userSo));
    }

    /**
     * 用户登录
     * @param userSo
     * @return
     */
    @CrossOrigin
    @PostMapping("login")
    public Message login(@RequestBody UserSo userSo) {
        User user = userService.login(userSo);
        if(ParamUtil.isNullOrEmpty(user)) {
            return new Message().setCode(611).setMessage("账号或密码错误！");
        } else {
            HttpSession session = this.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(1800 * 60);
            return new Message().setObj(session.getAttribute("user")).setCode(200).setMessage("登录成功！");
        }
    }

    /**
     * 修改密码
     * @param userSo
     * @return
     */
    @PostMapping("/password/change")
    public Message changePassword(@RequestBody UserSo userSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(userService.changePassword(userSo, user.getId()));
    }

    /**
     * 个人信息修改
     * @param userSo
     * @return
     */
    @PostMapping("/data/change")
    public Message changeData(@RequestBody UserSo userSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(userService.changeData(userSo, user.getId()));
    }

    /**
     * 用户退出登录
     * @return
     */
    @PostMapping("logout")
    public Message logout() {
        this.getSession().invalidate();
        return new Message().setMessage("退出登录成功！");
    }

}
