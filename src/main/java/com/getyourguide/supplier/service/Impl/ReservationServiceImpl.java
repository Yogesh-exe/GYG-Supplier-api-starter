package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {

    public ReservationServiceImpl(ProductIdDeserializer productIdDeserializer,
                                  ProductIdValidator productIdValidator,
                                  MyCompanyClientService myCompanyClientService) {
        super(productIdDeserializer, productIdValidator, myCompanyClientService);
    }

    @Override
    public Reserve200ResponseDTO reserve(Product product, ReservationRequestDataDTO data) {
        return null;
    }

    @Override
    public CancelReservation200ResponseDTO cancelReservation(String reservationReference, String gygBookingReference) {
        return null;
    }
}
