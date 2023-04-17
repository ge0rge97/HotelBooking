package com.george.spring.hotelBooking.repository;

import com.george.spring.hotelBooking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
