package com.linewell.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.oauth.pojo.User;

import java.util.*;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 16:16
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@Primary
@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User(1, "test-user1", "12345"));
        users.add(new User(2, "test-user2", "12345"));
        users.add(new User(3, "test-user3", "12345"));
        users.add(new User(4, "test-user4", "12345"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = users.stream()
                .filter((u) -> u.getUserName().equals(s))
                .findFirst();
        if (!user.isPresent())
            throw new UsernameNotFoundException("there's no user founded!");
        else {
            Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities();
            return UserDetailConverter.convert(user.get(),grantedAuths);
        }
    }

    /**
     * 获得用户所有角色的权限.
     */
    private Set<GrantedAuthority> obtainGrantedAuthorities() {
        Set<GrantedAuthority> authSet =  new HashSet<>();
        authSet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authSet.add(new SimpleGrantedAuthority("ROLE_USER"));
        authSet.add(new SimpleGrantedAuthority("eureka-client1/info"));
        return authSet;
    }

    private static class UserDetailConverter {
        static UserDetails convert(User user,Set<GrantedAuthority> grantedAuths) {
            MyUserDetails details =  new MyUserDetails(user,grantedAuths);
            return details;
        }
    }
}
