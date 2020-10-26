package com.cinema.model.dto;

import com.cinema.model.Ticket;
import com.cinema.model.User;
import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private User user;
    private List<Ticket> tickets;

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(User user, List<Ticket> tickets) {
        this.user = user;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
