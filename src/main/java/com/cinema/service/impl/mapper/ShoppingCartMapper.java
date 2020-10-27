package com.cinema.service.impl.mapper;

import com.cinema.model.ShoppingCart;
import com.cinema.model.dto.ShoppingCartRequestDto;
import com.cinema.model.dto.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    private final TicketMapper ticketMapper;

    public ShoppingCartMapper(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    public ShoppingCart mapDtoToCart(ShoppingCartRequestDto shoppingCartRequestDto) {
        return new ShoppingCart(shoppingCartRequestDto.getUser(),
                shoppingCartRequestDto.getTickets());
    }

    public ShoppingCartResponseDto mapCartToDto(ShoppingCart shoppingCart) {
        return new ShoppingCartResponseDto(shoppingCart.getUser().getId(),
                shoppingCart.getTickets().stream()
                        .map(ticketMapper::mapTicketToDto)
                        .collect(Collectors.toList()));
    }
}
