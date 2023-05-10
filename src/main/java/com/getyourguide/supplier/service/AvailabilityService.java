package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import com.mycompany.openapi.model.ProductDTO;
import java.time.OffsetDateTime;


public interface AvailabilityService extends GYGService {
    default GetAvailabilities200ResponseDTO getAvailabilities(String strProductId, OffsetDateTime fromDateTime,
                                                              OffsetDateTime toDateTime) {

        ProductDTO product = this.getValidProduct(strProductId);
        return this.getAvailabilities(product, fromDateTime, toDateTime);
    }

    GetAvailabilities200ResponseDTO getAvailabilities(ProductDTO product, OffsetDateTime fromDateTime,
                                                      OffsetDateTime toDateTime);
}
