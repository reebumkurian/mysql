package com.rmk.mysql.repository;

import com.rmk.mysql.model.MovieType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieTypeRepository extends CrudRepository<MovieType, Integer> {

    MovieType findOne(Integer id);

    MovieType findByMovieTypeName(String movieTypeName);
}
