package com.palekov.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palekov.AbstractApiTest;
import com.palekov.DataFactory;
import com.palekov.dto.BookingDto;
import com.palekov.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class BookingControllerApiTests extends AbstractApiTest {

    @MockBean
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        Mockito.reset(bookingService);
    }

    @Test
    void whenSendValidRequestOnGetBookingByIdThenBookingIsReturned() throws Exception {
        BookingDto booking = DataFactory.getBooking();
        Long bookingId = 1L;
        Mockito.when(bookingService.getBookingById(bookingId)).thenReturn(booking);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(booking);

        mockMvc.perform(MockMvcRequestBuilders.get("/booking/{bookingId}", bookingId)
                        .param("id", bookingId.toString())
                        .contentType(mediaTypeJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andExpect(MockMvcResultMatchers.content().contentType(mediaTypeJson));
    }

    @Test
    void whenSendGetBookingRequestAndNoBookingsCreatedThenNotFoundStatusCodeReturned() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bookings")
                .contentType(mediaTypeJson))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

