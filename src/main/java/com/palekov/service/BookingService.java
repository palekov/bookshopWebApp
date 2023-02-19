package com.palekov.service;

import com.palekov.dto.BookingDto;
import com.palekov.mapper.BookingMapper;
import com.palekov.repository.BookingRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    protected final BookingMapper mapper = Mappers.getMapper(BookingMapper.class);

    public BookingDto getBookingById(Long bookId) {
        return mapper.toBookingDto(bookingRepository.findBookingById(bookId));
    }

    public List<BookingDto> getAllBookings() {
        return mapper.toListOfBookingDto(bookingRepository.findAll());
    }

    public BookingDto createBooking(BookingDto bookingDto) {
        bookingRepository.save(mapper.toBookingEntity(bookingDto));
        return bookingDto;
    }
}
