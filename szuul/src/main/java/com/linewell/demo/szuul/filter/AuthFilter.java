package com.linewell.demo.szuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/1/20 0020 17:24
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
public class AuthFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        //类型为pre,前置
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //顺序为数字为6
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        //无条件执行
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        //TODO 实现自己需要执行的逻辑如,鉴定权限相关.....
        log.info("authFilter----->pre_type----->order=6");
        return null;
    }
}
