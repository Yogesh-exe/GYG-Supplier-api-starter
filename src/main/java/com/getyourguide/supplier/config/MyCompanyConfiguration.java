package com.getyourguide.supplier.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.getyourguide.mycompany")
@EnableFeignClients(clients = {com.getyourguide.mycompany.client.MyCompanyClient.class})
public class MyCompanyConfiguration {
}
