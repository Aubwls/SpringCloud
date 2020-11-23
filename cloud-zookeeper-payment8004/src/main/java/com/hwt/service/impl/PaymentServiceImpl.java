package com.hwt.service.impl;

import com.hwt.entity.pojo.Payment;
import com.hwt.mapper.PaymentMapper;
import com.hwt.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;


    @Override
    public void insert(Payment payment) {
        paymentMapper.insert(payment);
    }

    @Override
    public Payment selectById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
