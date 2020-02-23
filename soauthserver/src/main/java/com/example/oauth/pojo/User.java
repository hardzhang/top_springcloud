package com.example.oauth.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 16:19
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class User implements Serializable {

    public User(){}

    public User(Integer seq,String userName,String password){
       this.seq = seq;
       this.userName = userName;
       this.password = password;
    }

    private Integer seq;

    private String userName;

    private String  password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
