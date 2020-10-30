package com.cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieRequestDto {
    @NotNull(message = "Please provide title for movie")
    private String title;
    @Size(max = 40, message = "description should not exceed 40 characters")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
