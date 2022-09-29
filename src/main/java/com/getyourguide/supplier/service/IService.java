package com.getyourguide.supplier.service;

import com.getyourguide.supplier.exception.InvalidProductException;
import com.getyourguide.supplier.product.ProductId;

public interface IService {

    ProductId getValidProduct(String strProductId) throws InvalidProductException;

}

