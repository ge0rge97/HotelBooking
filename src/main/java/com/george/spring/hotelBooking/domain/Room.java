package com.george.spring.hotelBooking.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double pricePerNight;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
