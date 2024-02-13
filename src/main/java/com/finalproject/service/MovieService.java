package com.finalproject.service;

import com.finalproject.model.Movie;
import com.finalproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {
	
private final MovieRepository movieRepository;
    
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    

    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    public List<Movie> filmAra(String filmAdi) {
        return movieRepository.findByTitleIgnoreCaseLike(filmAdi);
    }

    public Movie filmEkle(Movie movie) {
        return movieRepository.save(movie);
    }
	
    public List<Movie> findByCreatedBy(String username) {
        return movieRepository.findByCreatedBy(username);
    }
    
    public void updateMovie(Movie updatedMovie) {
        
        Optional<Movie> existingMovieOptional = movieRepository.findById(updatedMovie.getId());

        if (existingMovieOptional.isPresent()) {
            Movie existingMovie = existingMovieOptional.get();
           
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setYear(updatedMovie.getYear());
            existingMovie.setCategory(updatedMovie.getCategory());
          
            movieRepository.save(existingMovie);
        } else {
        	
        }
    }
    
    public List<Movie> getMoviesByCategory(String category) {
        return movieRepository.findByCategory(category);
    }

    }

