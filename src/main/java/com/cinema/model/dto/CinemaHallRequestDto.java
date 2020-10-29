package com.cinema.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CinemaHallRequestDto {
    @NotNull(message = "please provide capacity")
    @Min(20)
    private Integer capacity;
    @Size(max = 20)
    private String description;

    public Integer getCapacity() {
        return capacity;
    }

    public void setId(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
