package com.cinema.controllers;

import com.cinema.model.ShoppingCart;
import com.cinema.model.Ticket;
import com.cinema.model.dto.MovieSessionRequestDto;
import com.cinema.model.dto.ShoppingCartRequestDto;
import com.cinema.model.dto.ShoppingCartResponseDto;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import com.cinema.service.impl.mapper.MovieSessionMapper;
import com.cinema.service.impl.mapper.ShoppingCartMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private ShoppingCartMapper shoppingCartMapper;
    private UserService userService;
    private MovieSessionMapper movieSessionMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  MovieSessionMapper movieSessionMapper) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public ShoppingCart addMovies(@RequestParam MovieSessionRequestDto movieSessionRequestDto,
                                  @RequestParam Long userId) {
        ShoppingCartRequestDto shoppingCartRequestDto = new ShoppingCartRequestDto();
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(movieSessionMapper.mapToMovieSessionFromDto(movieSessionRequestDto),
                userService.getById(userId)));
        shoppingCartRequestDto.setUser(userService.getById(userId));
        shoppingCartRequestDto.setTickets(tickets);
        return shoppingCartMapper.mapDtoToCart(shoppingCartRequestDto);
    }

    @GetMapping("/{userId}")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartMapper
                .mapCartToDto(shoppingCartService.getByUser(userService.getById(userId)));
    }

}
