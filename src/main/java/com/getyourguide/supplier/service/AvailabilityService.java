package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import com.getyourguide.mycompany.model.Product;
import java.time.OffsetDateTime;


public interface AvailabilityService extends IService {
    default GetAvailabilities200ResponseDTO getAvailabilities(String strProductId, OffsetDateTime fromDateTime,
                                                              OffsetDateTime toDateTime) {

        Product product = this.getValidProduct(strProductId);
        return this.getAvailabilities(product, fromDateTime, toDateTime);
    }

    GetAvailabilities200ResponseDTO getAvailabilities(Product product, OffsetDateTime fromDateTime,
                                                      OffsetDateTime toDateTime);
}
