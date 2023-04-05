package com.palekov.bookshop.integration;

import com.palekov.bookshop.AbstractDbTest;
import com.palekov.bookshop.DataFactory;
import com.palekov.bookshop.dto.BookingDto;
import com.palekov.bookshop.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceIntegrationDbTests extends AbstractDbTest {

    @Autowired
    private BookingService bookingService;

    @Test
    void whenBookingDtoWithDataIsProvidedThenBookingIsCreated() {
        BookingDto bookingDto = DataFactory.getBooking();
        bookingService.createBooking(bookingDto);
        BookingDto actualBooking = bookingService.getBookingById(bookingDto.getId());
        Assertions.assertEquals(bookingDto.getAddress(), actualBooking.getAddress());
        Assertions.assertEquals(bookingDto.getDate(), actualBooking.getDate());
        Assertions.assertEquals(bookingDto.getTime(), actualBooking.getTime());
    }
}
