package com.linewell.demo.szuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 17:25
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class LoginPostFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        //类型为post,后置
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        //顺序为数字为999
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }


    @Override
    public boolean shouldFilter() {
        //无条件执行
        return true;
    }

    @Override
    public Object run() {
        //TODO 实现自己需要执行的逻辑如,登录后做些什么
        log.info("loginFilter----->post_type----->order=999");
        return null;
    }
}
