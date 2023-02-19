package com.palekov.integration;

import com.palekov.AbstractDbTest;
import com.palekov.DataFactory;
import com.palekov.dto.BookingDto;
import com.palekov.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceIntegrationDbTests extends AbstractDbTest {

    @Autowired
    private BookingService bookingService;

    @Test
    void whenBookingDtoWithDataIsProvidedThenBookingIsCreated() {
        BookingDto bookingDto = DataFactory.getBooking();
        BookingDto createdDto = bookingService.createBooking(bookingDto);
        BookingDto actualBooking = bookingService.getBookingById(createdDto.getId());
        Assertions.assertEquals(bookingDto.getAddress(), actualBooking.getAddress());
        Assertions.assertEquals(bookingDto.getDate(), actualBooking.getDate());
        Assertions.assertEquals(bookingDto.getTime(), actualBooking.getTime());
    }
}
