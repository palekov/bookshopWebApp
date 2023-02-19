package com.palekov.model;

import com.palekov.model.enums.Role;
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

    private String name;
    private String address;
    private String email;
    private String phone;

    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    private Integer role_id;
    private String login;
    private String password;

    @OneToMany (mappedBy="user", fetch=FetchType.EAGER)
    private Set<Booking> bookings;
}
