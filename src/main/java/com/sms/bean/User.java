package com.sms.bean;

/**
 * Created by zy on 2016/5/27.
 */
public class User extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
