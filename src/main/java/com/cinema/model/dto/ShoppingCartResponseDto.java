package com.cinema.model.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private Long userId;
    private List<TicketResponseDto> tickets;

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(Long userId, List<TicketResponseDto> tickets) {
        this.userId = userId;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
