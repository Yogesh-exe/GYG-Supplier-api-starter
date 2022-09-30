package com.getyourguide.supplier.service;

import com.getyourguide.mycompany.model.Product;
import com.getyourguide.supplier.exception.InvalidProductException;

public interface IService {

    Product getValidProduct(String strProductId) throws InvalidProductException;

}

