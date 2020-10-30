package com.cinema.controllers;

import com.cinema.model.Order;
import com.cinema.model.ShoppingCart;
import com.cinema.model.User;
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
    public OrderResponseDto completeOrder(Authentication auth) {
        User user = getCurrentUser(auth);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        Order order = ordersService.completeOrder(shoppingCart.getTickets(), user);
        return orderMapper.mapToDtoFromOrder(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        return ordersService.getOrderHistory(getCurrentUser(auth)).stream()
                .map(orderMapper::mapToDtoFromOrder)
                .collect(Collectors.toList());
    }

    private User getCurrentUser(Authentication authentication) {
        UserDetails principle = (UserDetails) authentication.getPrincipal();
        return userService.findByEmail(principle.getUsername()).orElseThrow();
    }
}
