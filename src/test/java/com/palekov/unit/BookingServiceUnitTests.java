package com.palekov.unit;

import com.palekov.AbstractUnitTest;
import com.palekov.DataFactory;
import com.palekov.dto.BookingDto;
import com.palekov.repository.BookingRepository;
import com.palekov.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceUnitTests extends AbstractUnitTest {
    @Autowired
    private BookingService bookingService;
    @MockBean
    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        Mockito.reset(bookingRepository);
    }

    @Test
    void whenBookingIsNotFoundThenExceptionIsAppears() {

    }

    @Test
    void whenBookingRequestedFromRepositoryThenBookingDtoReturned() {
//        List<BookingDto> bookingsToReturn = new ArrayList<>();
//        BookingDto bookingDtoToReturn = DataFactory.getBooking();
//        Mockito.when(bookingRepository.findBookingById(1L))
//                .thenReturn(new ArrayList<BookingDto>(bookingDtoToReturn));

    }
}
