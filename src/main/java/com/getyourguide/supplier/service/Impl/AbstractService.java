package com.getyourguide.supplier.service.Impl;

import com.getyourguide.supplier.exception.InvalidProductException;
import com.getyourguide.supplier.exception.OperationId;
import com.getyourguide.supplier.product.ProductId;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.IService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService implements IService {

    private final ProductIdDeserializer productIdDeserializer;
    private final ProductIdValidator productIdValidator;

    @Override
    public ProductId getValidProduct(String strProductId) throws InvalidProductException {
        var productId = this.productIdDeserializer.deserialize(strProductId).orElseThrow(
            () -> new InvalidProductException(OperationId.DEFAULT,
                String.format("The given productId [%s] is not parse-able.", strProductId))
        );
        boolean isValidProduct = productIdValidator.validateProductId(productId);
        if (!isValidProduct) {
            throw new InvalidProductException(OperationId.DEFAULT, "ProductId provided is invalid.");
        }
        return productId;
    }
}
