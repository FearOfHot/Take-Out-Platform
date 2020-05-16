package com.clc.springboot.demo1.facade.entities;

public class OrderData {

    private Long year;

    private Long month;

    private Long orderNumber;

    private Long orderTotalDishNumber;

    private Float orderTotalPrice;

    private Float orderAvgPrice;

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderTotalDishNumber() {
        return orderTotalDishNumber;
    }

    public void setOrderTotalDishNumber(Long orderTotalDishNumber) {
        this.orderTotalDishNumber = orderTotalDishNumber;
    }

    public Float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Float getOrderAvgPrice() {
        return orderAvgPrice;
    }

    public void setOrderAvgPrice(Float orderAvgPrice) {
        this.orderAvgPrice = orderAvgPrice;
    }
}
