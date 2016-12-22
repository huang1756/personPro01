package com.hyq.admin.entity;

import com.hyq.admin.common.BaseEntity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/21.
 */
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    private Integer index;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
