package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Movie;
import ro.itschool.repository.MovieRepository;
import ro.itschool.service.MovieService;


import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        this.movieRepository.save(movie);
        return movie;
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }





}
