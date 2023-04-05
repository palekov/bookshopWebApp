package com.palekov.bookshop.unit;

import com.palekov.bookshop.AbstractUnitTest;
import com.palekov.bookshop.service.repository.BookingRepository;
import com.palekov.bookshop.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

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
