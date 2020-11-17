package com.hwt.mapper;

import com.hwt.entity.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

}