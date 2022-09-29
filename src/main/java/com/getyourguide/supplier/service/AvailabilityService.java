package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import java.time.OffsetDateTime;

public interface AvailabilityService {
    GetAvailabilities200ResponseDTO getAvailabilities(String productId, OffsetDateTime fromDateTime,
                                                      OffsetDateTime toDateTime);
}
