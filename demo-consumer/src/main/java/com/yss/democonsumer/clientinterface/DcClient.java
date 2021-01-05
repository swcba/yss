package com.yss.democonsumer.clientinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther shiwei
 * @Date 2020/12/22
 */

@FeignClient("demo-client")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();

}
