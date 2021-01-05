package com.yss.democonsumer.contorller;



import com.yss.democonsumer.clientinterface.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiwei
 * @date 2020/12/22
 */

@RestController
public class DcContorller {
    @Autowired
    DcClient dcClient;

    @GetMapping("consumer-feign")
    public String dc2(){

        return dcClient.consumer();
    }

}
