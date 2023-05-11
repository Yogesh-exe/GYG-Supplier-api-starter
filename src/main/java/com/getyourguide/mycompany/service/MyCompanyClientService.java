package com.getyourguide.mycompany.service;

import com.getyourguide.mycompany.client.MyCompanyBookingClient;
import com.getyourguide.mycompany.client.MyCompanyProductClient;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.wrapper.MyCompanyExceptionToGYGExceptionWrapper;

import com.mycompany.openapi.model.BookingResponseDTO;
import com.mycompany.openapi.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCompanyClientService {

    private final MyCompanyBookingClient bookingClient;
    private final MyCompanyProductClient productClient;

    private final MyCompanyExceptionToGYGExceptionWrapper gygExceptionWrapper;

    //TODO: Implement the methods which calls the client endpoint in the mycompany system.
    // Example of a getProduct detail endpoint based on the supplier productId
    public ProductDTO getProduct(String productId) {
        try {
            //TODO: Correct the productId being passed
            return productClient.getproductById(productId).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingResponseDTO getBooking(String reservationReference) {
        try {
            //TODO: Correct the productId being passed
            return bookingClient.getBookingById(reservationReference).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }
}
