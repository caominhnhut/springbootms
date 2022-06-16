package com.msa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix // for hystrix.stream
@EnableDiscoveryClient // for hystrix.stream
public class GateWayApplication{

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication.class, args);
    }
}
