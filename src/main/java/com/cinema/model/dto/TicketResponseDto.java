package com.cinema.model.dto;

public class TicketResponseDto {
    private Long movieSessionId;
    private Long userId;

    public TicketResponseDto() {
    }

    public TicketResponseDto(Long movieSessionId, Long userId) {
        this.movieSessionId = movieSessionId;
        this.userId = userId;
    }

    public Long getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(Long movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
