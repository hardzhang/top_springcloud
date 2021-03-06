package com.linewell.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers(PermitAllUrl.permitAllUrl()).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable();*/
        http.authorizeRequests()
                .antMatchers(PermitAllUrl.permitAllUrl()).permitAll() // 放开权限的url
                .anyRequest().authenticated();
    }
}