package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseReservationCancellationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseReservationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.mapper.ReservationMapper;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {

    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ProductIdDeserializer productIdDeserializer,
                                  ProductIdValidator productIdValidator,
                                  MyCompanyClientService myCompanyClientService,
                                  ReservationMapper reservationMapper) {
        super(productIdDeserializer, productIdValidator, myCompanyClientService);
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Reserve200ResponseDTO reserve(Product product, ReservationRequestDataDTO data) {
        //TODO: Implement this method
        return new ErrorResponseReservationDTO().errorCode(ErrorResponseReservationDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }

    @Override
    public CancelReservation200ResponseDTO cancelReservation(String reservationReference, String gygBookingReference) {
        //TODO: Implement this method
        return new ErrorResponseReservationCancellationDTO().errorCode(
            ErrorResponseReservationCancellationDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }
}
