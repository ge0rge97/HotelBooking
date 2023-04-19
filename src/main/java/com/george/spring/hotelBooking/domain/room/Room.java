package com.george.spring.hotelBooking.domain.room;


import com.george.spring.hotelBooking.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

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
