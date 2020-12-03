package com.hwt.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: hwt
 * @date: 2020/12/2
 * @description:
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
