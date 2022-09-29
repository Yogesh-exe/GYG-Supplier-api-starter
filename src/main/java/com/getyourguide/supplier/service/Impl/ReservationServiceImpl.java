package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.supplier.product.ProductId;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {

    public ReservationServiceImpl(ProductIdDeserializer productIdDeserializer,
                                  ProductIdValidator productIdValidator) {
        super(productIdDeserializer, productIdValidator);
    }

    @Override
    public Reserve200ResponseDTO reserve(ProductId productId, ReservationRequestDataDTO data) {
        return null;
    }

    @Override
    public CancelReservation200ResponseDTO cancelReservation(String reservationReference, String gygBookingReference) {
        return null;
    }
}
