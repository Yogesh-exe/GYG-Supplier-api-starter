package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.Book200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingCancellationRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.BookingRequestDataDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.CancelBooking200ResponseDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseBookingCancellationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseBookingDTO;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.mapper.BookingMapper;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends AbstractService implements BookingService {

    private final BookingMapper bookingMapper;

    public BookingServiceImpl(ProductIdDeserializer productIdDeserializer,
                              ProductIdValidator productIdValidator,
                              MyCompanyClientService myCompanyClientService,
                              BookingMapper bookingMapper) {
        super(productIdDeserializer, productIdValidator, myCompanyClientService);
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Book200ResponseDTO book(Product product, BookingRequestDataDTO bookingRequestDataDTO) {
        //TODO: Implement this method
        return new ErrorResponseBookingDTO().errorCode(ErrorResponseBookingDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }

    @Override
    public CancelBooking200ResponseDTO cancelBooking(Product product,
                                                     BookingCancellationRequestDataDTO bookingCancellationRequestDataDTO) {
        //TODO: Implement this method
        return new ErrorResponseBookingCancellationDTO().errorCode(
            ErrorResponseBookingCancellationDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }

}
