package com.clc.springboot.demo1.controller;


import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.entities.Admin;
import com.clc.springboot.demo1.facade.so.AdminSo;
import com.clc.springboot.demo1.service.AdminService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    /**
     * 管理员用户登录
     * @param adminSo
     * @return
     */
    @CrossOrigin
    @PostMapping("login")
    public Message login(@RequestBody AdminSo adminSo) {
        Admin admin = adminService.login(adminSo);
        if(ParamUtil.isNullOrEmpty(admin)) {
            return new Message().setCode(611).setMessage("账号或密码错误！");
        } else {
            HttpSession session = this.getSession();
            session.setAttribute("admin", admin);
            session.setMaxInactiveInterval(1800 * 60);
            return new Message().setObj(session.getAttribute("admin")).setCode(200).setMessage("登录成功！");
        }
    }

    /**
     * 修改密码
     * @param adminSo
     * @return
     */
    @PostMapping("/password/change")
    public Message changePassword(@RequestBody AdminSo adminSo) {
        Admin admin = (Admin) this.getAttribute("admin");
        return new Message().setObj(adminService.changePassword(adminSo, admin.getId()));
    }

    /**
     * 个人信息修改
     * @param adminSo
     * @return
     */
    @PostMapping("/data/change")
    public Message changeDate(@RequestBody AdminSo adminSo) {
        Admin admin = (Admin) this.getAttribute("admin");
        return new Message().setObj(adminService.changeData(adminSo, admin.getId()));
    }

    /**
     * 管理员退出登录
     * @return
     */
    @PostMapping("logout")
    public Message logout() {
        this.getSession().invalidate();
        return new Message().setMessage("退出登录成功！");
    }

}
