package com.palekov.bookshop.model;

import com.palekov.bookshop.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@Entity(name = "users")
public class User {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String phone;

    @Column
    private Integer role_id;
    @Column
    private String login;
    @Column
    private String password;

    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @OneToMany (mappedBy="user", fetch=FetchType.EAGER)
    private Set<Booking> bookings;
}
