package com.hwt.controller;

import com.hwt.entity.pojo.Payment;
import com.hwt.result.Result;
import com.hwt.result.ReturnResult;
import com.hwt.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Payment payment){
        paymentService.insert(payment);
        return ReturnResult.OK();
    }

    @RequestMapping(value= "/getById", method = RequestMethod.POST)
    public Result<Payment> getById(@RequestBody Payment payment){
        return ReturnResult.OK(paymentService.selectById(payment.getId()));
    }

}
