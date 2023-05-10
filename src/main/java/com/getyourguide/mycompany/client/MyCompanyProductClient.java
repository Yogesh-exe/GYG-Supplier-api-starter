package com.getyourguide.mycompany.client;

import com.mycompany.api.ProductsApi;
import feign.config.MyCompanyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    value = "my-company-product-client",
    url = "${service.properties.mycompany.client.url}",
    configuration = MyCompanyFeignConfig.class)
public interface MyCompanyProductClient extends ProductsApi {
}
