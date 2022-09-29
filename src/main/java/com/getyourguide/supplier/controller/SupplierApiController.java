package com.getyourguide.supplier.controller;

import com.getyourguide.connectivity.api.supplierapi.SupplierApi;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.GetGetAvailabilities200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.PostBook200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.PostCancelBooking200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.PostCancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.PostReserve200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDTO;
import org.springframework.http.ResponseEntity;

public class SupplierApiController implements SupplierApi {
    @Override
    public ResponseEntity<GetGetAvailabilities200ResponseDTO> getGetAvailabilities(String productId,
                                                                                   String fromDateTime,
                                                                                   String toDateTime) {
        return null;
    }

    @Override
    public ResponseEntity<PostBook200ResponseDTO> postBook(BookingRequestDTO bookingRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<PostCancelBooking200ResponseDTO> postCancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<PostCancelReservation200ResponseDTO> postCancelReservation(
        ReservationCancellationRequestDTO reservationCancellationRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<PostReserve200ResponseDTO> postReserve(ReservationRequestDTO reservationRequestDTO) {
        return null;
    }
}
