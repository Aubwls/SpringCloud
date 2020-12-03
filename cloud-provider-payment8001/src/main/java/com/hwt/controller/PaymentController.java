package com.hwt.controller;

import com.hwt.entity.pojo.Payment;
import com.hwt.result.Result;
import com.hwt.result.ReturnResult;
import com.hwt.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Payment payment){
        paymentService.insert(payment);
        log.info("服务器:{} 正在运行！", serverPort);
        return ReturnResult.OK();
    }

    @RequestMapping(value= "/getById", method = RequestMethod.POST)
    public Result<Payment> getById(@RequestBody Payment payment){
        log.info("服务器:{} 正在运行！", serverPort);
        return ReturnResult.OK(paymentService.selectById(payment.getId()));
    }

    @RequestMapping(value = "/dicovery", method = RequestMethod.POST)
    public Result discover(){
        discoveryClient.getServices().forEach( element -> {
            log.info("{}",element);
        });
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(instance -> {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        });
        return ReturnResult.OK();
    }

    @GetMapping(value = "/lb")
    public String getLb(){
        return serverPort;
    }
}
