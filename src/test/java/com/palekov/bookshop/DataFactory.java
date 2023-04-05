package com.palekov.bookshop;

import com.palekov.bookshop.dto.BookingDto;
import com.palekov.bookshop.dto.ProductDto;
import com.palekov.bookshop.dto.UserDto;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;

public class DataFactory {

    public static BookingDto getBooking() {
        return BookingDto.builder()
                .user(new UserDto())
                .product(new ProductDto())
                .address("test address1")
                .date(Date.valueOf("2023-03-10"))
                .time(Time.valueOf("10:00:00"))
                .status(new HashSet<>())
                .quantity(1)
                .build();
    }
}
