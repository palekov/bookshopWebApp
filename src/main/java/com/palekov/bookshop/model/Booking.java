package com.palekov.bookshop.model;

import com.palekov.bookshop.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column
    private String delivery_address;
    @Column
    private Date delivery_date;
    @Column
    private Time delivery_time;
    @Column
    private Integer quantity;

    @ElementCollection(targetClass = BookingStatus.class)
    @JoinTable(name = "booking_status", joinColumns = @JoinColumn(name = "status_id"))
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<BookingStatus> status;

}
