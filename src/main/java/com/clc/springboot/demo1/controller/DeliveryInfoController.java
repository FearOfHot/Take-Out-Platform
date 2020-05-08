package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.DeliveryInfoSo;
import com.clc.springboot.demo1.service.DeliveryInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("delivery/info")
public class DeliveryInfoController extends BaseController {

    @Resource
    private DeliveryInfoService deliveryInfoService;

    /**
     * 查看用户所有的配送信息
     * @return
     */
    @PostMapping("query")
    public Message queryAllDeliveryInfo() {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(deliveryInfoService.findAllDeliveryInfo(user.getId()));
    }

    /**
     * 新建/编辑用户的配送信息
     * @param deliveryInfoSo
     * @return
     */
    @PostMapping("save")
    public Message saveDeliveryInfo(@RequestBody DeliveryInfoSo deliveryInfoSo) {
        User user = (User) this.getAttribute("user");
        Long userId = user.getId();
        return new Message().setObj(deliveryInfoService.saveDeliveryInfo(deliveryInfoSo, userId));
    }

    /**
     * 删除用户的配送信息
     * @param deliveryInfoSo
     * @return
     */
    @PostMapping("delete")
    public Message deleteDeliveryInfo(@RequestBody DeliveryInfoSo deliveryInfoSo) {
        return new Message().setObj(deliveryInfoService.deleteDeliveryInfo(deliveryInfoSo));
    }

}
