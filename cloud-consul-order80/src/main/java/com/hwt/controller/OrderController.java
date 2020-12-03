package com.hwt.controller;

import com.hwt.entity.pojo.Payment;
import com.hwt.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    //单机
    private static final String PAYMENT_URL = "http://172.16.9.74:8006";
    //集群
    //private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Result<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, Result.class);
    }

    @PostMapping("/getById")
    public Result<Payment> getById(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/getById", payment, Result.class);
    }

    @PostMapping("/getConsul")
    public String getZookeeper(){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/consul", new Payment(), String.class);
    }
}
