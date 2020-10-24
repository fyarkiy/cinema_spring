package com.cinema.model.dto;

public class MovieResponseDto {
    private Long id;
    private String title;

    public MovieResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MovieResponseDto{ id=" + id
                + ", title='" + title + "'}";
    }
}
