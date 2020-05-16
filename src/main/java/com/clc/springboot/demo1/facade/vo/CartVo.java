package com.clc.springboot.demo1.facade.vo;

public class CartVo {

    private Long id;

    private Long userId;

    private Long dishId;

    private String dishUrl;

    private String dishBase64Url;

    private String dishName;

    private String dishDesc;

    private Long dishNumber;

    private Float price;

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

    public String getDishUrl() {
        return dishUrl;
    }

    public void setDishUrl(String dishUrl) {
        this.dishUrl = dishUrl;
    }
    public String getDishName() {
        return dishName;
    }

    public String getDishBase64Url() {
        return dishBase64Url;
    }

    public void setDishBase64Url(String dishBase64Url) {
        this.dishBase64Url = dishBase64Url;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
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

}
