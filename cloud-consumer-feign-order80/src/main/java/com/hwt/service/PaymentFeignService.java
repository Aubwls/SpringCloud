package com.hwt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: hwt
 * @date: 2020/12/3
 * @description:
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/lb")
    String getLb();

    @GetMapping(value = "/payment/timeout")
    String paymentFeignTimeout();
}
