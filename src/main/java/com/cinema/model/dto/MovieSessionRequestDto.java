package com.cinema.model.dto;

import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    private String showTime;
    @NotNull (message = "Movie Id can't be null")
    private Long movieId;
    @NotNull (message = "Cinema hall id can't be null")
    private Long cinemaHallId;

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
