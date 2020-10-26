package com.cinema.service.impl.mapper;

import com.cinema.model.ShoppingCart;
import com.cinema.model.dto.ShoppingCartRequestDto;
import com.cinema.model.dto.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCart mapDtoToCart(ShoppingCartRequestDto shoppingCartRequestDto) {
        return new ShoppingCart(shoppingCartRequestDto.getUser(),
                shoppingCartRequestDto.getTickets());
    }

    public ShoppingCartResponseDto mapCartToDto(ShoppingCart shoppingCart) {
        return new ShoppingCartResponseDto(shoppingCart.getUser(), shoppingCart.getTickets());
    }
}
