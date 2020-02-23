package com.linewell.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 16:16
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class MyUserDetails extends User {

    private com.example.oauth.pojo.User user;

    public MyUserDetails(com.example.oauth.pojo.User user,Set<GrantedAuthority> grantedAuths) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, grantedAuths);
        this.user = user;
    }

    public com.example.oauth.pojo.User getUser() {
        return user;
    }

    public void setUser(com.example.oauth.pojo.User user) {
        this.user = user;
    }
}
