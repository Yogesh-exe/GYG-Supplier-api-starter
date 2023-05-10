package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.mycompany.openapi.model.BookingDTO;
import com.mycompany.openapi.model.BookingResponseDTO;
import com.mycompany.openapi.model.ProductDTO;

public interface ReservationService extends GYGService {

    default Reserve200ResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {
        ProductDTO product = this.getValidProduct(reservationRequestDTO.getData().getProductId());
        return this.createReservation(product, reservationRequestDTO.getData());
    }

    default CancelReservation200ResponseDTO cancelReservation(
        ReservationCancellationRequestDTO reservationCancellationRequestDTO) {
        BookingResponseDTO reservation =
            this.getReservation(reservationCancellationRequestDTO.getData().getReservationReference(),
                reservationCancellationRequestDTO.getData().getGygBookingReference());

        return cancelReservation(reservation.getBooking());
    }

    BookingResponseDTO getReservation(String reservationReference, String gygBookingReference);

    Reserve200ResponseDTO createReservation(ProductDTO product, ReservationRequestDataDTO data);

    CancelReservation200ResponseDTO cancelReservation(BookingDTO reservation);
}
