package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.so.DishSo;
import com.clc.springboot.demo1.service.DishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("dish")
public class DishController extends BaseController {

    @Resource
    private DishService dishService;

    /**
     * 查看所有菜品
     * @return
     */
    @PostMapping("query")
    public Message findAllDish() {
        return new Message().setObj(dishService.findAllDish());
    }

    /**
     * 新建/编辑菜品
     * @param dishSo
     * @return
     */
    @PostMapping("save")
    public Message saveDish(@RequestBody DishSo dishSo) {
        return new Message().setObj(dishService.saveDish(dishSo));
    }

    /**
     * 删除菜品
     * @param dishSo
     * @return
     */
    @PostMapping("delete")
    public Message deleteDish(@RequestBody DishSo dishSo) {
        return new Message().setObj(dishService.deleteDish(dishSo));
    }
}
