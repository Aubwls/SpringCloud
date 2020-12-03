package com.hwt.controller;

import com.hwt.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: hwt
 * @date: 2020/12/3
 * @description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class orderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getLb")
    public String getLb(){
        return paymentFeignService.getLb();
    }

    @GetMapping("/timeout")
    public String timeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
