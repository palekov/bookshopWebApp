package com.palekov.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@Entity(name = "products")
public class Product {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Float price;
    @Column
    private String image_path;

    @OneToMany(mappedBy = "product")
    private Set<Store> storeItems;

    @OneToMany (mappedBy="product")
    private Set<Booking> bookings;
}
