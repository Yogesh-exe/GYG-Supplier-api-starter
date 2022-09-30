package com.getyourguide.mycompany.service;

import com.getyourguide.mycompany.client.MyCompanyClient;
import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.supplier.product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCompanyClientService {

    private final MyCompanyClient client;

    public Product getProduct(ProductId productId){
        try {
            return client.getProductDetails(productId.toString());
        } catch (MyCompanyTechnicalException e) {
            e.printStackTrace();
        } catch (MyCompanyBusinessException e) {
            e.printStackTrace();
        } catch (MyCompanyServiceException e) {
            e.printStackTrace();
        }
//TODO: Yogesh to remove this and provide the error wrapper class above.
        return null;

    }

}
