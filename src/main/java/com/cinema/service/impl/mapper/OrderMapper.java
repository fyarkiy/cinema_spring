package com.cinema.service.impl.mapper;

import com.cinema.model.Order;
import com.cinema.model.dto.OrderResponseDto;
import com.cinema.model.dto.TicketResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final TicketMapper ticketMapper;

    public OrderMapper(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    public OrderResponseDto mapToDtoFromOrder(Order order) {
        List<TicketResponseDto> tickets = order.getTickets().stream()
                .map(ticketMapper::mapTicketToDto)
                .collect(Collectors.toList());
        return new OrderResponseDto(order.getUser().getId(), tickets);
    }
}
