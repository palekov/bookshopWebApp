package com.palekov.dto;

import com.palekov.model.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private UserDto user;
    private ProductDto product;
    private String address;
    private Date date;
    private Time time;
    private Set<BookingStatus> status = new HashSet<>();
    private Integer quantity;
}
