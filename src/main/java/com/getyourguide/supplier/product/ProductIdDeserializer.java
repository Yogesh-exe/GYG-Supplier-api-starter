package com.getyourguide.supplier.product;

import com.getyourguide.supplier.exception.InvalidProductException;
import java.util.Optional;

public interface ProductIdDeserializer {

    Optional<ProductId> deserialize(String strProductId) throws InvalidProductException;
}
