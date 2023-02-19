package com.palekov.controller;

import com.palekov.dto.BookingDto;
import com.palekov.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController extends AbstractController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDto> getAllBooks() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDto getBook(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
        return bookingDto;
    }
}
