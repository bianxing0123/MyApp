package com.example.demo.okhttp.entity.entity;

import android.net.Uri;

import java.io.Serializable;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopInfoEntity implements Serializable {

    @Override
    public String toString() {
        return "ShopInfoEntity{" +
                "shopinfoid=" + shopinfoid +
                ", shopname='" + shopname + '\'' +
                ", shopsellamount=" + shopsellamount +
                ", startsendprice=" + startsendprice +
                ", delivercost=" + delivercost +
                ", shopImage='" + shopImage + '\'' +
                '}';
    }

    private int shopinfoid;

    private String shopname;

    private int shopsellamount;

    private int startsendprice;

    private int delivercost;

    private String shopImage;

    public int getShopinfoid() {
        return shopinfoid;
    }

    public void setShopinfoid(int shopinfoid) {
        this.shopinfoid = shopinfoid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getShopsellamount() {
        return shopsellamount;
    }

    public void setShopsellamount(int shopsellamount) {
        this.shopsellamount = shopsellamount;
    }

    public int getStartsendprice() {
        return startsendprice;
    }

    public void setStartsendprice(int startsendprice) {
        this.startsendprice = startsendprice;
    }

    public int getDelivercost() {
        return delivercost;
    }

    public void setDelivercost(int delivercost) {
        this.delivercost = delivercost;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

}
