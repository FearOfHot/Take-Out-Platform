package com.clc.springboot.demo1.facade.so;

public class CartSo {

    private Long id;

    private Long userId;

    private Long dishId;

    private Long dishNumber;

    private Float price;

    /**
     * 直接修改的数字
     */
    private Long changeNumber;

    /**
     * 加一减一时的数字 1
     */
    private Long oneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(Long dishNumber) {
        this.dishNumber = dishNumber;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getOneNumber() {
        return oneNumber;
    }

    public void setOneNumber(Long oneNumber) {
        this.oneNumber = oneNumber;
    }

    public Long getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Long changeNumber) {
        this.changeNumber = changeNumber;
    }
}
