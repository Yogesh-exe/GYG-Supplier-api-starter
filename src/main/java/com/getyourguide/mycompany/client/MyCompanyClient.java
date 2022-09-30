package com.getyourguide.mycompany.client;

import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.getyourguide.mycompany.model.Product;
import feign.config.MyCompanyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    value = "my-company-client",
    url = "${service.properties.mycompany.client.url}",
    configuration = MyCompanyFeignConfig.class)
public interface MyCompanyClient {

    @GetMapping(value = "/mycompany/product/{productId}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    Product getProductDetails(@PathVariable("productId") String productId)
        throws MyCompanyTechnicalException, MyCompanyBusinessException, MyCompanyServiceException;

}
