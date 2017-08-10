package com.example.zz.listviewcountdemo.bean;

/**
 * 类描述：实体类
 * 创建人：zz
 * 创建时间： 2017/8/9 18:06
 */


public class DataBean {
    private String money;
    private int status;

    public DataBean(String money, int status) {
        this.money = money;
        this.status = status;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
