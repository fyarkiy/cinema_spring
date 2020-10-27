package com.cinema.service.impl.mapper;

import com.cinema.model.Ticket;
import com.cinema.model.dto.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponseDto mapTicketToDto(Ticket ticket) {
        return new TicketResponseDto(ticket.getMovieSession().getId(), ticket.getUser().getId());
    }
}
