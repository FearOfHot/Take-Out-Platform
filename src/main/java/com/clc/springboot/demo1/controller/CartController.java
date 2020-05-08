package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.controller.base.BaseController;
import com.clc.springboot.demo1.facade.base.Message;
import com.clc.springboot.demo1.facade.entities.User;
import com.clc.springboot.demo1.facade.so.CartSo;
import com.clc.springboot.demo1.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cart")
public class CartController extends BaseController {

    @Resource
    private CartService cartService;

    /**
     * 新添加进购物车
     * @param cartSo
     * @return
     */
    @PostMapping("save")
    public Message saveCart(@RequestBody CartSo cartSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.saveCart(cartSo, user.getId()));
    }

    /**
     * 手动输入购物车内某菜品的数量
     * @param cartSo
     * @return
     */
    @PostMapping("/number/update")
    public Message updateDishNumber(@RequestBody CartSo cartSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.updateDishNumber(cartSo.getChangeNumber(), cartSo.getDishId(), user.getId()));
    }

    /**
     * 对购物车内某菜品数量进行加一或者减一操作
     * @param cartSo
     * @return
     */
    @PostMapping("/one/number/update")
    public Message updateDishOneNumber(@RequestBody CartSo cartSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.updateDishOneNumber(cartSo.getOneNumber(), cartSo.getDishId(), user.getId()));
    }

    /**
     * 查看用户当前购物车情况
     * @return
     */
    @PostMapping("query")
    public Message findAllDishByUserId() {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.findAllDishByUserId(user.getId()));
    }

    /**
     * 删除用户购物车内的某个菜品
     * @param cartSo
     * @return
     */
    @PostMapping("/one/delete")
    public Message deleteDishInCart(@RequestBody CartSo cartSo) {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.deleteDishInCart(cartSo.getDishId(), user.getId()));
    }

    /**
     * 清空用户购物车
     * @return
     */
    @PostMapping("/all/delete")
    public Message deleteAllDishByUserId() {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.deleteAllDishByUserId(user.getId()));
    }

    /**
     * 计算某个菜品的总价格
     * @return
     */
    @PostMapping("price")
    public Message updateCartPrice() {
        User user = (User) this.getAttribute("user");
        return new Message().setObj(cartService.updateCartPrice(user.getId()));
    }

}
