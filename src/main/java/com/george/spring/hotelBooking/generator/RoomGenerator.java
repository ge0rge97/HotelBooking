package com.george.spring.hotelBooking.generator;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.domain.room.RoomType;
import com.george.spring.hotelBooking.domain.room.Status;
import com.github.javafaker.Faker;

import java.util.Locale;

public class RoomGenerator {
    private static final Faker faker = new Faker(new Locale("en-US"));

    public static Room generateRoom() {
        Room room = new Room();
        room.setName(RoomType.randomValue().toString());
        room.setDescription(faker.lorem().sentence());
        room.setPricePerNight(faker.number().randomDouble(10, 50, 300));
        room.setStatus(Status.AVAILABLE_ROOM);
        return room;
    }
}
