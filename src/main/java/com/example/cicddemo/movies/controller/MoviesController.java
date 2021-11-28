package com.example.cicddemo.movies.controller;

import com.example.cicddemo.movies.dtos.MovieDto;
import com.example.cicddemo.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<MovieDto> allMovies = moviesService.getAllMovies();
        return ResponseEntity.ok().body(allMovies);
    }

    @PostMapping("/")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie) {
        MovieDto savedMovie = moviesService.saveMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieForId(@PathVariable String id) {
        Optional<MovieDto> movie = moviesService.getMovie(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());

        }
        return ResponseEntity.notFound().build();
    }
}
