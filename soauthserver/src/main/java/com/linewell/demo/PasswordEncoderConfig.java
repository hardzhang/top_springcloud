package com.linewell.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码校验器<br>
 *
 *
 * @author
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args){
       System.out.println(new BCryptPasswordEncoder().encode("12345"));
        System.out.println(new BCryptPasswordEncoder().matches("12345","$2a$10$dA59l0QEOcm7Lg41T643cuOtLYEb4zZG5vgRlMnOj/IORtzQFzpWK"));
        System.out.println(new BCryptPasswordEncoder().matches("123456","$2a$10$qb2gNlqt3HINbkxwvddH7.QmCpDRyhTYaM/KhW4pRzTt6sOjDSUAO"));

    }
}
