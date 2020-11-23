package com.hwt.service;

import com.hwt.entity.pojo.Payment;

/**
 * @author: hwt
 * @date: 2020/11/17
 * @description:
 */
public interface PaymentService {

    void insert(Payment payment);

    Payment selectById(Long id);
}

