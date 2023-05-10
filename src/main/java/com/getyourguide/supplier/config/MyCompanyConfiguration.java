package com.getyourguide.supplier.config;

import com.getyourguide.mycompany.client.MyCompanyBookingClient;
import com.getyourguide.mycompany.client.MyCompanyProductClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.getyourguide.mycompany")
@EnableFeignClients(clients = {MyCompanyBookingClient.class, MyCompanyProductClient.class})
public class MyCompanyConfiguration {
}
