package com.getyourguide.supplier.service.Impl;

import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.exception.InvalidProductException;
import com.getyourguide.supplier.exception.OperationId;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.GYGService;
import com.mycompany.openapi.model.ProductDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService implements GYGService {

    private final ProductIdValidator productIdValidator;
    protected final MyCompanyClientService myCompanyClientService;

    @Override
    public ProductDTO getValidProduct(String productId) throws InvalidProductException {

        boolean isValidProduct = productIdValidator.validateProductId(productId);
        if (!isValidProduct) {
            throw new InvalidProductException(OperationId.DEFAULT, "ProductId provided is invalid.");
        }

        return myCompanyClientService.getProduct(productId);
    }
}
