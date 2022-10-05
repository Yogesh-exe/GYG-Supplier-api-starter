package com.getyourguide.mycompany.service;

import com.getyourguide.mycompany.client.MyCompanyClient;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.wrapper.MyCompanyExceptionToGYGExceptionWrapper;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.supplier.exception.OperationId;
import com.getyourguide.supplier.product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCompanyClientService {

    private final MyCompanyClient client;

    private final MyCompanyExceptionToGYGExceptionWrapper gygExceptionWrapper;

    //TODO: Implement the methods which calls the client endpoint in the mycompany system.
    // Example of a getProduct detail endpoint based on the supplier productId
    public Product getProduct(ProductId productId) {
        try {
            //TODO: Correct the productId being passed
            return client.getProductDetails("productId.toString()");
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException,OperationId.DEFAULT);
        }
    }

}
