package com.palekov.mapper;

import com.palekov.dto.BookingDto;
import com.palekov.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toBookingEntity(BookingDto source);

    @Mapping(target = "address", source = "delivery_address")
    @Mapping(target = "date", source = "delivery_date")
    @Mapping(target = "time", source = "delivery_time")
    BookingDto toBookingDto(Booking source);

    List<BookingDto> toListOfBookingDto(Iterable<Booking> source);
}
