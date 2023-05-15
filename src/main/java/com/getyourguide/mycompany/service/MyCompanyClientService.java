package com.getyourguide.mycompany.service;

import com.getyourguide.mycompany.client.MyCompanyBookingClient;
import com.getyourguide.mycompany.client.MyCompanyProductClient;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.wrapper.MyCompanyExceptionToGYGExceptionWrapper;
import com.mycompany.openapi.model.AvailabilityDTO;
import com.mycompany.openapi.model.BookingDTO;
import com.mycompany.openapi.model.BookingResponseDTO;
import com.mycompany.openapi.model.ProductDTO;
import java.time.OffsetDateTime;
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
            return productClient.getproductById(productId).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public AvailabilityDTO getProductAvailability(String productId,
                                                  OffsetDateTime startDateTime,
                                                  OffsetDateTime endDateTime) {
        try {
            return productClient.getProductAvailability(productId, startDateTime, endDateTime).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingResponseDTO getBooking(String reservationReference) {
        try {
            return bookingClient.getBookingById(reservationReference).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingResponseDTO createBooking(BookingDTO bookingDTO) {
        try {
            return bookingClient.createBooking(bookingDTO).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingDTO deleteBooking(String reservationReference) {
        try {
            return bookingClient.deleteBooking(reservationReference).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingResponseDTO cancelBooking(String reservationReference) {
        try {
            return bookingClient.cancelTheBooking(reservationReference).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }

    public BookingResponseDTO confirmBooking(String reservationReference) {
        try {
            return bookingClient.confirmBooking(reservationReference).getBody();
        } catch (MyCompanyException myCompanyException) {
            throw gygExceptionWrapper.getWrappedException(myCompanyException);
        }
    }
}
