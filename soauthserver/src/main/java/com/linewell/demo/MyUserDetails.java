package com.linewell.demo;

import java.util.Collections;
import org.springframework.security.core.userdetails.User;
/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 16:16
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class MyUserDetails extends User {

    private com.example.oauth.pojo.User user;

    public MyUserDetails(com.example.oauth.pojo.User user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public com.example.oauth.pojo.User getUser() {
        return user;
    }

    public void setUser(com.example.oauth.pojo.User user) {
        this.user = user;
    }
}
