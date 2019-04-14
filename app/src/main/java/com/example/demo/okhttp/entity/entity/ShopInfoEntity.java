package com.example.demo.okhttp.entity.entity;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopInfoEntity {

    private String shopname;

    private String shopImage;

    private int sellamount;

    private String sendinfo;

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public int getSellamount() {
        return sellamount;
    }

    public void setSellamount(int sellamount) {
        this.sellamount = sellamount;
    }

    public String getSendinfo() {
        return sendinfo;
    }

    public void setSendinfo(String sendinfo) {
        this.sendinfo = sendinfo;
    }
}
