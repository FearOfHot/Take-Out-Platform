package com.clc.springboot.demo1.facade.vo;

public class DishVo {

    private Long id;

    private String name;

    private String url;

    private Float price;

    private String desc;

    private Long salesVolume;

    private String base64Url;

    private Boolean inCurrentUserCartOrNot;

    private Long inCurrentUserCartDishNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Long salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getBase64Url() {
        return base64Url;
    }

    public void setBase64Url(String base64Url) {
        this.base64Url = base64Url;
    }

    public Boolean getInCurrentUserCartOrNot() {
        return inCurrentUserCartOrNot;
    }

    public void setInCurrentUserCartOrNot(Boolean inCurrentUserCartOrNot) {
        this.inCurrentUserCartOrNot = inCurrentUserCartOrNot;
    }

    public Long getInCurrentUserCartDishNumber() {
        return inCurrentUserCartDishNumber;
    }

    public void setInCurrentUserCartDishNumber(Long inCurrentUserCartDishNumber) {
        this.inCurrentUserCartDishNumber = inCurrentUserCartDishNumber;
    }
}
