package com.hwt.controller;

import com.hwt.entity.pojo.Payment;
import com.hwt.lb.LoadBalancer;
import com.hwt.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    //单机
    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Result<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, Result.class);
    }

    @PostMapping("/getById")
    public Result<Payment> getById(@RequestBody Payment payment){
        log.info("运行了！！！！");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/getById", payment, Result.class);
    }

    @PostMapping("/getById2")
    public Result<Payment> getById2(@RequestBody Payment payment){
        ResponseEntity<Result> result = restTemplate.postForEntity(PAYMENT_URL + "/payment/getById", payment, Result.class);
        return result.getBody();
    }

    @GetMapping("getLb")
    public String getLb(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getLb", String.class);
    }
    @GetMapping("getLb2")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtils.isEmpty(instances)){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        return String.valueOf(serviceInstance.getUri().getPort());
    }
}
