package com.cinema.controllers;

import com.cinema.model.Order;
import com.cinema.model.ShoppingCart;
import com.cinema.model.dto.OrderResponseDto;
import com.cinema.service.OrdersService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import com.cinema.service.impl.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrdersService ordersService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderController(ShoppingCartService shoppingCartService,
                           OrdersService ordersService,
                           UserService userService, OrderMapper orderMapper) {
        this.shoppingCartService = shoppingCartService;
        this.ordersService = ordersService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        UserDetails principle = (UserDetails) authentication.getPrincipal();
        String email = principle.getUsername();
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findByEmail(email).orElseThrow());
        Order order = ordersService.completeOrder(shoppingCart.getTickets(),
                shoppingCart.getUser());
        return orderMapper.mapToDtoFromOrder(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication authentication) {
        UserDetails principle = (UserDetails) authentication.getPrincipal();
        return ordersService.getOrderHistory(userService
                .findByEmail(principle.getUsername()).orElseThrow()).stream()
                .map(orderMapper::mapToDtoFromOrder)
                .collect(Collectors.toList());
    }
}
