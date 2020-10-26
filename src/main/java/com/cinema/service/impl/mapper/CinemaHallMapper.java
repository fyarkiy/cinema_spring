package com.cinema.service.impl.mapper;

import com.cinema.model.CinemaHall;
import com.cinema.model.dto.CinemaHallRequestDto;
import com.cinema.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHall mapDtoToCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }

    public CinemaHallResponseDto mapCinemaHallToDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(), cinemaHall.getDescription());
    }
}
