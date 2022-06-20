package com.msa.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient  // for service registry
public class DepartmentApplication{

    public static void main(String[] args){
        SpringApplication.run(DepartmentApplication.class, args);
    }

    @Bean
    @LoadBalanced // for routing to the right instance.
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
