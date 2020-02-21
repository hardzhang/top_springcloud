package com.linewell.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 14:06
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/{name}")
    public String getUserName(@PathVariable String name) {
        return "hello,"+ name;
    }
}
