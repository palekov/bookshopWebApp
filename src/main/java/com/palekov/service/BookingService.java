package com.palekov.service;

import com.palekov.dto.BookingDto;
import com.palekov.mapper.BookingMapper;
import com.palekov.model.Booking;
import com.palekov.repository.BookingRepository;
import com.palekov.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ProductRepository productRepository;

    protected final BookingMapper mapper = Mappers.getMapper(BookingMapper.class);

    public BookingDto getBookingById(Long bookId) {
        return mapper.toBookingDto(bookingRepository.findBookingById(bookId));
    }

    public List<BookingDto> getAllBookings() {
        return mapper.toListOfBookingDto(bookingRepository.findAll());
    }

    @Transactional
    public BookingDto createBooking(BookingDto bookingDto) {
        return mapper.toBookingDto(bookingRepository.save(mapper.toBookingEntity(bookingDto)));
    }
}
