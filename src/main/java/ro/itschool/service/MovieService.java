package ro.itschool.service;

import ro.itschool.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

    public void  addMovie(Movie movie);


}
