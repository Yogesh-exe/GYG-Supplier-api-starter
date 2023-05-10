package com.getyourguide.supplier.config;

import com.getyourguide.mycompany.client.MyCompanyBookingClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.getyourguide.mycompany")
@EnableFeignClients(clients = {MyCompanyBookingClient.class})
public class MyCompanyConfiguration {
}
