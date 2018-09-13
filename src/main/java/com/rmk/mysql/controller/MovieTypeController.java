package com.rmk.mysql.controller;

import com.rmk.mysql.model.MovieType;
import com.rmk.mysql.repository.MovieTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/movie-type")
public class MovieTypeController {

    @Autowired
    private MovieTypeRepository movieTypeRepository;

    @PostMapping("/save")
    ResponseEntity<MovieType> save(@RequestBody MovieType movieType) {
        return ResponseEntity.ok(movieTypeRepository.save(movieType));
    }

    @GetMapping("/all")
    ResponseEntity<Iterable<MovieType>> getAllMovieTypes() {
        return ResponseEntity.ok(movieTypeRepository.findAll());
    }

    @GetMapping("/name/{movie-type-name}")
    ResponseEntity<MovieType> findByMovieTypeName(@PathVariable("movie-type-name") final String movieTypeName) {
        final MovieType movieType = movieTypeRepository.findByMovieTypeName(movieTypeName);
        return ResponseEntity.ok(movieType);
    }
}
