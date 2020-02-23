package com.linewell.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AccountController {

    @GetMapping("/principal")
    @PreAuthorize("hasAnyAuthority('user')")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/query")
    @PreAuthorize("hasAnyAuthority('all')")
    public String all () {
        return "具有 all 权限";
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('user')")
    public String user() {
        return "xxxx";
    }
}

