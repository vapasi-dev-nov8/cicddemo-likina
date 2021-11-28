package com.example.cicddemo.movies.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.example.cicddemo.movies.entities.MovieEntity;

import java.util.Objects;

public class MovieDto {
    private String id;
    private String name;
    private String actorName;
    private String directorName;

    @JsonCreator
    public MovieDto(String name, String actorName, String directorName) {
      //  this(null, name, actorName, directorName);
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public MovieDto(String id, String name, String actorName, String directorName) {
        this.id = id;
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public static MovieDto dtoFrom(MovieEntity movieEntity) {
        return new MovieDto(
                movieEntity.getId(),
                movieEntity.getName(),
                movieEntity.getActorName(),
                movieEntity.getDirectorName());
    }

    public  String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDto)) return false;
        MovieDto movies = (MovieDto) o;
        return Objects.equals(name, movies.name) && Objects.equals(actorName, movies.actorName) && Objects.equals(directorName, movies.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, actorName, directorName);
    }
}
