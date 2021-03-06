package com.cinema.controllers;

import com.cinema.model.User;
import com.cinema.model.dto.ShoppingCartResponseDto;
import com.cinema.service.MovieSessionService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import com.cinema.service.impl.mapper.ShoppingCartMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping("/movie-sessions")
    public void addMovies(@RequestParam Long movieSessionId,
                          Authentication auth) {
        shoppingCartService.addSession(movieSessionService.getById(movieSessionId),
                getCurrentUser(auth));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        return shoppingCartMapper.mapCartToDto(shoppingCartService.getByUser(getCurrentUser(auth)));
    }

    private User getCurrentUser(Authentication authentication) {
        UserDetails principle = (UserDetails) authentication.getPrincipal();
        return userService.findByEmail(principle.getUsername()).orElseThrow();
    }
}
