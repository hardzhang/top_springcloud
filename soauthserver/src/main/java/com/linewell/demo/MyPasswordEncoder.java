package com.linewell.demo;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 17:38
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
