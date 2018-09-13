package com.rmk.mysql.repository;

import com.rmk.mysql.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    public List<Movie> findByMovieName(String movieName);

    List<Movie> findMovieById(final Integer id);
}
