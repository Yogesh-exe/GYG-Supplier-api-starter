package com.getyourguide.supplier.service;

import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;
import com.getyourguide.supplier.product.ProductId;

public interface BookingService extends IService {

    default Book200ResponseDTO book(BookingRequestDTO bookingRequestDTO) {
        ProductId productId = this.getValidProduct(bookingRequestDTO.getData().getProductId());
        return this.book(productId, bookingRequestDTO.getData());
    }

    default CancelBooking200ResponseDTO cancelBooking(
        BookingCancellationRequestDTO bookingCancellationRequestDTO) {
        ProductId productId = this.getValidProduct(bookingCancellationRequestDTO.getData().getProductId());
        return this.cancelBooking(productId, bookingCancellationRequestDTO.getData());
    }

    Book200ResponseDTO book(ProductId productId, BookingRequestDataDTO bookingRequestDataDTO);

    CancelBooking200ResponseDTO cancelBooking(ProductId productId,
                                              BookingCancellationRequestDataDTO bookingCancellationRequestDataDTO);

}
