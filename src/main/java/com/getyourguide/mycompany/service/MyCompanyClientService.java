package com.getyourguide.mycompany.service;

import com.getyourguide.mycompany.client.MyCompanyClient;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.wrapper.MyCompanyExceptionToGYGExceptionWrapper;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.supplier.product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCompanyClientService {

    private final MyCompanyClient client;

    private final MyCompanyExceptionToGYGExceptionWrapper gygExceptionWrapper;

    public Product getProduct(ProductId productId) {
        try {
            return client.getProductDetails(productId.toString());
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

}
