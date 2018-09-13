package com.rmk.mysql.model.request;

public class MovieRequest {

    private String movieName;

    private Integer movieTypeId;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieTypeId() {
        return movieTypeId;
    }

    public void setMovieTypeId(Integer movieTypeId) {
        this.movieTypeId = movieTypeId;
    }
}
