package com.linewell.demo.sappmore.inter;

import com.linewell.demo.sappmore.controller.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client1")
public interface FeignService {

    //服务中方法的映射路径
    @RequestMapping("/info")
    String hello();

}
