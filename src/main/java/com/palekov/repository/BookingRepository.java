package com.palekov.repository;

import com.palekov.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    Booking findBookingById(Long id);

    List<Booking> findAll();

//    Booking save(Booking);
}
