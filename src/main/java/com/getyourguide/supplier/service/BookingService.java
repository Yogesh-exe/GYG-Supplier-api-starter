package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;
import com.getyourguide.mycompany.model.Product;

public interface BookingService extends IService {

    default Book200ResponseDTO book(BookingRequestDTO bookingRequestDTO) {
        Product product = this.getValidProduct(bookingRequestDTO.getData().getProductId());
        return this.book(product, bookingRequestDTO.getData());
    }

    default CancelBooking200ResponseDTO cancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO) {
        Product product = this.getValidProduct(bookingCancellationRequestDTO.getData().getProductId());
        return this.cancelBooking(product, bookingCancellationRequestDTO.getData());
    }

    Book200ResponseDTO book(Product product, BookingRequestDataDTO bookingRequestDataDTO);

    CancelBooking200ResponseDTO cancelBooking(Product product,
                                              BookingCancellationRequestDataDTO bookingCancellationRequestDataDTO);

}
