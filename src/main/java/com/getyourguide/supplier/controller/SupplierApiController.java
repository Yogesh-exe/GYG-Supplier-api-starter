package com.getyourguide.supplier.controller;

import com.getyourguide.connectivity.api.supplierapi.SupplierApi;
import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.supplier.service.AvailabilityService;
import com.getyourguide.supplier.service.BookingService;
import com.getyourguide.supplier.service.ReservationService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SupplierApiController implements SupplierApi {

    private final AvailabilityService availabilityService;
    private final ReservationService reservationService;
    private final BookingService bookingService;


    @Override
    public ResponseEntity<GetAvailabilities200ResponseDTO> getAvailabilities(String productId,
                                                                             OffsetDateTime fromDateTime,
                                                                             OffsetDateTime toDateTime) {
        availabilityService.getAvailabilities(productId, fromDateTime, toDateTime);
        return null;
    }

    @Override
    public ResponseEntity<Reserve200ResponseDTO> reserve(ReservationRequestDTO reservationRequestDTO) {
        reservationService.reserve(reservationRequestDTO);
        return null;
    }

    @Override
    public ResponseEntity<CancelReservation200ResponseDTO> cancelReservation(
        ReservationCancellationRequestDTO reservationCancellationRequestDTO) {
        reservationService.cancelReservation(reservationCancellationRequestDTO);
        return null;
    }

    @Override
    public ResponseEntity<Book200ResponseDTO> book(BookingRequestDTO bookingRequestDTO) {
        bookingService.book(bookingRequestDTO);
        return null;
    }

    @Override
    public ResponseEntity<CancelBooking200ResponseDTO> cancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO) {
        bookingService.cancelBooking(bookingCancellationRequestDTO);
        return null;
    }
}
