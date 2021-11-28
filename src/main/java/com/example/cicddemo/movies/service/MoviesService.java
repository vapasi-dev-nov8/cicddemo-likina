package com.example.cicddemo.movies.service;

import com.example.cicddemo.movies.dtos.MovieDto;
import com.example.cicddemo.movies.entities.MovieEntity;
import com.example.cicddemo.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movies = new ArrayList<>();

        for (MovieEntity movieEntity : moviesRepository.findAll()) {
            movies.add(MovieDto.dtoFrom(movieEntity));
        }

        return movies;
    }

    public MovieDto saveMovie(MovieDto movieDto) {
        MovieEntity movieEntity = MovieEntity.entityFrom(movieDto);
        MovieEntity savedMovieEntity = moviesRepository.save(movieEntity);
        return MovieDto.dtoFrom(savedMovieEntity);
    }

    public Optional<MovieDto> getMovie(String id) {
        Optional<MovieEntity> movieEntity = moviesRepository.findById(id);
        return movieEntity.map(MovieDto::dtoFrom);
    }
}
