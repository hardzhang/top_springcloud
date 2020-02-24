package com.linewell.demo.sapp.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@Order(11)
@EnableOAuth2Sso
public class OAuthClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
    /*
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	 *//*http.csrf().disable()
    		.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated();*//*
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login**", "/webjars/**")
                .permitAll()
                .antMatchers("/sapp/login**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf()
                .csrfTokenRepository(
                        CookieCsrfTokenRepository
                                .withHttpOnlyFalse());
    }
*/
   /* @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(PermitAllUrl.permitAllUrl());
    }*/

}
