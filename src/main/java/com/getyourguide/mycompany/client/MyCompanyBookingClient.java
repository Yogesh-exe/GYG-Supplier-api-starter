package com.getyourguide.mycompany.client;

import com.mycompany.api.BookingsApi;
import feign.config.MyCompanyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    value = "my-company-booking-client",
    url = "${service.properties.mycompany.client.url}",
    configuration = MyCompanyFeignConfig.class)
public interface MyCompanyBookingClient extends BookingsApi {
}
