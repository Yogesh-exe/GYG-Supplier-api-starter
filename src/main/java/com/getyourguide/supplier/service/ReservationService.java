package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.CancelReservation200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.Reserve200ResponseDTO;

public interface ReservationService {

   Reserve200ResponseDTO reserve(ReservationRequestDTO reservationRequestDTO);

    CancelReservation200ResponseDTO cancelReservation(
        ReservationCancellationRequestDTO reservationCancellationRequestDTO);
}
