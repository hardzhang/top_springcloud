package com.linewell.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 16:13
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */

@Configuration
@EnableOAuth2Client
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
       oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
               .tokenKeyAccess("isAuthenticated()")
                 .allowFormAuthenticationForClients();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                .withClient("eureka-client1")//客户端ID
                .redirectUris("http://localhost:52601/sapp/info","http://www.baidu.com")
                //.redirectUris("http://localhost:52601/login","http://localhost:9099/login","http://localhost:9099/info")
                //.authorizedGrantTypes("authorization_code", "password", "refresh_token")//设置验证方式
                .authorizedGrantTypes("authorization_code","client_credentials","password", "refresh_token")//设置验证方式
                .scopes("read", "write")
                .secret(passwordEncoder.encode("secret_test"))
                .accessTokenValiditySeconds(10000) //token过期时间
                .refreshTokenValiditySeconds(10000)
                .autoApprove()
                .and().inMemory()
                .withClient("eureka-client2")//客户端ID
                .authorizedGrantTypes("authorization_code","client_credentials","password", "refresh_token")//设置验证方式
                .scopes("read", "write")
                .secret(passwordEncoder.encode("secret_test"))
                .accessTokenValiditySeconds(10000) //token过期时间
                .refreshTokenValiditySeconds(10000); //refresh过期时间*/
           clients.inMemory()
                .withClient("client1")
                .secret(passwordEncoder.encode("secret_test"))
                .authorizedGrantTypes("authorization_code", "refresh_token",
                        "password", "implicit")// 授权类型
                .scopes("all")
                .redirectUris("http://localhost:52601/sapp/login","http://www.baidu.com")
                .autoApprove(true) // 自动认证
				.accessTokenValiditySeconds(3600);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userService); //配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
    }

    @Bean
    public TokenStore tokenStore() {
        //使用内存的tokenStore
        return new InMemoryTokenStore();
    }
}