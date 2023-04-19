package com.george.spring.hotelBooking.web.dto.mappers;

import com.george.spring.hotelBooking.domain.User;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
