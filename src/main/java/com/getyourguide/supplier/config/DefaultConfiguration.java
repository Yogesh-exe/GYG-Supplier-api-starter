package com.getyourguide.supplier.config;

import com.getyourguide.supplier.product.ProductIdValidator;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    @Bean
    ProductIdValidator getProductIdValidator() {
        return p -> true;
    }

}
