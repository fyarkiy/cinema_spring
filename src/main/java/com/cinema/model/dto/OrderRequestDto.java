package com.cinema.model.dto;

import java.util.List;

public class OrderRequestDto {
    private Long userId;
    private String email;
    private List<TicketResponseDto> tickets;

    public OrderRequestDto(Long userId, String email, List<TicketResponseDto> tickets) {
        this.userId = userId;
        this.email = email;
        this.tickets = tickets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TicketResponseDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponseDto> tickets) {
        this.tickets = tickets;
    }
}
