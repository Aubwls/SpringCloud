package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: hwt
 * @date: 2020/12/2
 * @description:
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //随机规则
        return new RandomRule();
    }
}
