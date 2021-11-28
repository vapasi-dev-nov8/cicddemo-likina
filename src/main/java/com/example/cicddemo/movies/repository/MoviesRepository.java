package com.example.cicddemo.movies.repository;

import com.example.cicddemo.movies.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity, String> {
}
