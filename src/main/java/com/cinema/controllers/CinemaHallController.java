package com.cinema.controllers;

import com.cinema.model.CinemaHall;
import com.cinema.model.dto.CinemaHallRequestDto;
import com.cinema.model.dto.CinemaHallResponseDto;
import com.cinema.service.CinemaHallService;
import com.cinema.service.impl.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-hall")
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public CinemaHall addCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallMapper.mapDtoToCinemaHall(cinemaHallRequestDto);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(ch -> cinemaHallMapper.mapCinemaHallToDto(ch))
                .collect(Collectors.toList());
    }
}
