package com.rmk.mysql.controller;

import com.rmk.mysql.model.Movie;
import com.rmk.mysql.model.MovieType;
import com.rmk.mysql.model.request.MovieRequest;
import com.rmk.mysql.repository.MovieRepository;
import com.rmk.mysql.repository.MovieTypeRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieTypeRepository movieTypeRepository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Movie>> all() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/name/{movie-name}")
    public ResponseEntity<Iterable<Movie>> findByName(@PathVariable("movie-name") String movieName) {
        return ResponseEntity.ok(movieRepository.findByMovieName(movieName));
    }

    @GetMapping("/id/{movie-id}")
    public ResponseEntity<Iterable<Movie>> findById(@PathVariable("movie-id") Integer id) {
        return ResponseEntity.ok(movieRepository.findMovieById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovies(@RequestBody final MovieRequest movieRequest) {
        final Integer movieTypeId = movieRequest.getMovieTypeId();
        final Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setActive(Boolean.TRUE);
        movie.setCreatedDate(DateTime.now().toString());
        movie.setUpdatedDate(DateTime.now().toString());
        if (movieTypeId != null) {
            final MovieType movieType = movieTypeRepository.findOne(movieTypeId);
            if (movieType != null) {
                movie.setMovieType(movieType);
            }
        }
        return ResponseEntity.ok(movieRepository.save(movie));
    }
}
