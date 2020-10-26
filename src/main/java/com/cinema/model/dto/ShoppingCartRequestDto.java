package com.cinema.model.dto;

import com.cinema.model.Ticket;
import com.cinema.model.User;
import java.util.List;

public class ShoppingCartRequestDto {
    private User user;
    private List<Ticket> tickets;

    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(User user, List<Ticket> tickets) {
        this.user = user;
        this.tickets = tickets;
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
