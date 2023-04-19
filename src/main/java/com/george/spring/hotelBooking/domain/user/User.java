package com.george.spring.hotelBooking.domain.user;

import com.george.spring.hotelBooking.domain.room.Room;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String passwordConfirmation;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Room> bookedRoom;
}
