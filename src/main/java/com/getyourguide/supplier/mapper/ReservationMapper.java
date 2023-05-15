package com.getyourguide.supplier.mapper;

import com.getyourguide.connectivity.supplierapi.openapi.model.BookingItemDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ReservationRequestDataDTO;
import com.mycompany.openapi.model.BookingDTO;
import com.mycompany.openapi.model.GuestDTO;
import com.mycompany.openapi.model.ProductDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public static BookingDTO toBookingDTO(ProductDTO product, ReservationRequestDataDTO data) {
        Integer quantity = data.getBookingItems().stream()
            .mapToInt(BookingItemDTO::getCount)
            .sum();
        return new BookingDTO().productId(data.getProductId())
            .startDateTime(data.getDateTime())
            .channelId("GYG")
            .quantity(quantity)
            .traveller(data.getBookingItems().stream().map(ReservationMapper::toGuestDTO).toList());
    }

    public static GuestDTO toGuestDTO(BookingItemDTO reserveBookingItem){
        return new GuestDTO().type(reserveBookingItem.getCategory().getValue());
    }
}
