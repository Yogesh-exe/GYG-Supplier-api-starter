package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import com.getyourguide.supplier.product.ProductId;
import java.time.OffsetDateTime;


public interface AvailabilityService extends IService{
    default  GetAvailabilities200ResponseDTO getAvailabilities(String strProductId, OffsetDateTime fromDateTime,
                                                      OffsetDateTime toDateTime) {

        ProductId productId = this.getValidProduct(strProductId);
        return this.getAvailabilities(productId, fromDateTime, toDateTime);
    }

    GetAvailabilities200ResponseDTO getAvailabilities(ProductId productId, OffsetDateTime fromDateTime,
                                                      OffsetDateTime toDateTime);
}
