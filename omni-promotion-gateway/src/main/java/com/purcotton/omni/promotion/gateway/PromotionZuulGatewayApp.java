package com.purcotton.omni.promotion.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.purcotton.omni.*"})
@EnableFeignClients
public class PromotionZuulGatewayApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(PromotionZuulGatewayApp.class,args );
    }
}
