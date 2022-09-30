package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;
import com.getyourguide.mycompany.model.Product;

public interface ReservationService extends IService {

    default Reserve200ResponseDTO reserve(ReservationRequestDTO reservationRequestDTO) {
        Product product = this.getValidProduct(reservationRequestDTO.getData().getProductId());
        return this.reserve(product, reservationRequestDTO.getData());
    }

    default CancelReservation200ResponseDTO cancelReservation(
        ReservationCancellationRequestDTO reservationCancellationRequestDTO) {
        return this.cancelReservation(reservationCancellationRequestDTO.getData().getReservationReference(),
            reservationCancellationRequestDTO.getData().getGygBookingReference());
    }

    Reserve200ResponseDTO reserve(Product product, ReservationRequestDataDTO data);

    CancelReservation200ResponseDTO cancelReservation(String reservationReference, String gygBookingReference);
}
