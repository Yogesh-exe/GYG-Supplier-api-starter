package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseReservationCancellationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseReservationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.mapper.ReservationMapper;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.ReservationService;
import com.mycompany.openapi.model.BookingDTO;
import com.mycompany.openapi.model.BookingResponseDTO;
import com.mycompany.openapi.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationServiceImpl extends AbstractService implements ReservationService {

    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ProductIdValidator productIdValidator,
                                  MyCompanyClientService myCompanyClientService,
                                  ReservationMapper reservationMapper) {
        super(productIdValidator, myCompanyClientService);
        this.reservationMapper = reservationMapper;
    }

    @Override
    public BookingResponseDTO getReservation(String reservationReference, String gygBookingReference) {
        return myCompanyClientService.getBooking(reservationReference);
    }

    @Override
    public Reserve200ResponseDTO createReservation(ProductDTO product, ReservationRequestDataDTO data) {
        log.info("Calling reservation for Product: {}, With GYG request: {}.", product.getId(), data);
        //TODO: Implement this method
        return new ErrorResponseReservationDTO().errorCode(
            ErrorResponseReservationDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }

    @Override
    public CancelReservation200ResponseDTO cancelReservation(BookingDTO reservation) {
        log.info("Calling cancel reservation for reservation: {}.", reservation.getBookingId());
        //TODO: Implement this method
        return new ErrorResponseReservationCancellationDTO().errorCode(
            ErrorResponseReservationCancellationDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }
}
