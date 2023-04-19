package com.george.spring.hotelBooking.domain.room;

import java.util.Random;

public enum RoomType {
    STANDARD, BEDROOM, STUDIO, APARTMENT;

    public static RoomType randomValue() {
        return RoomType.values()[new Random().nextInt(RoomType.values().length)];
    }
}
