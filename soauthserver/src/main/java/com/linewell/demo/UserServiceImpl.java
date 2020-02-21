package com.linewell.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.oauth.pojo.User;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        else
            return UserDetailConverter.convert(user.get());
    }

    private static class UserDetailConverter {
        static UserDetails convert(User user) {
            return new MyUserDetails(user);
        }
    }
}
