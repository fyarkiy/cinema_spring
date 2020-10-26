package com.cinema.model.dto;

public class CinemaHallResponseDto {
    private Long id;
    private String description;

    public CinemaHallResponseDto() {
    }

    public CinemaHallResponseDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
