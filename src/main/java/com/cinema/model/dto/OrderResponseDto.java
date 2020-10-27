package com.cinema.model.dto;

import java.util.List;

public class OrderResponseDto {
    private Long userId;
    private List<TicketResponseDto> tickets;

    public OrderResponseDto(Long userId, List<TicketResponseDto> tickets) {
        this.userId = userId;
        this.tickets = tickets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TicketResponseDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponseDto> tickets) {
        this.tickets = tickets;
    }
}
