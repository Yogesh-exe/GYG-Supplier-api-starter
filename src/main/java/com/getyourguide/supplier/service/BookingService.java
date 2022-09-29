package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;

public interface BookingService{

    Book200ResponseDTO book(BookingRequestDTO bookingRequestDTO);

    CancelBooking200ResponseDTO cancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO);
}
