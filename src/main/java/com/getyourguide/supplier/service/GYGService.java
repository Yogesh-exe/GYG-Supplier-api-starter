package com.getyourguide.supplier.service;

import com.getyourguide.supplier.exception.InvalidProductException;
import com.mycompany.openapi.model.ProductDTO;

public interface GYGService {

    ProductDTO getValidProduct(String strProductId) throws InvalidProductException;

}

