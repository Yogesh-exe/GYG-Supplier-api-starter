package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;
import com.mycompany.openapi.model.ProductDTO;

public interface BookingService extends GYGService {

    default Book200ResponseDTO book(BookingRequestDTO bookingRequestDTO) {
        ProductDTO product = this.getValidProduct(bookingRequestDTO.getData().getProductId());
        return this.book(product, bookingRequestDTO.getData());
    }

    default CancelBooking200ResponseDTO cancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO) {
        ProductDTO product = this.getValidProduct(bookingCancellationRequestDTO.getData().getProductId());
        return this.cancelBooking(product, bookingCancellationRequestDTO.getData());
    }

    Book200ResponseDTO book(ProductDTO product, BookingRequestDataDTO bookingRequestDataDTO);

    CancelBooking200ResponseDTO cancelBooking(ProductDTO product,
                                              BookingCancellationRequestDataDTO bookingCancellationRequestDataDTO);

}
