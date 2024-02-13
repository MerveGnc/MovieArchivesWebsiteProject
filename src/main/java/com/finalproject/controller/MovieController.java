package com.finalproject.controller;


import com.finalproject.model.Movie;
import com.finalproject.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "allMovies.jsp";
    }
    
    @GetMapping("/movies2")
    public String getAllMovies2(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "adminPage.jsp";
    }
    
    
    @GetMapping("/filmler")
    public String filmArama(@RequestParam("filmAdi") String encodedFilmAdi, Model model) {
        List<Movie> filmler = movieService.filmAra(encodedFilmAdi);
        
        model.addAttribute("filmler", filmler);

        return "movie.jsp";
    }
    
    @GetMapping("/movies-search")
    public String searchMoviesByCategory(@RequestParam("category") String category, Model model) {
       
        List<Movie> movies = movieService.getMoviesByCategory(category);
          
        model.addAttribute("movies", movies);
        
        return "moviesByCategory.jsp";
    }


    
    @PostMapping("/film-ekle")
    public String saveMovie(@ModelAttribute("movie") Movie movie, Principal principal) {
        String username = principal.getName(); 
        movie.setCreatedBy(username); 
        movieService.saveMovie(movie);
        return "redirect:/added";
    }
    
    @PostMapping("/film-ekle2")
    public String saveMovie2(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/admindashboard";
    }

    @GetMapping("/film-ekle")
    public String filmEkleSayfasi(Model model) {
        model.addAttribute("movie", new Movie());
        return "added";
    }
    
    @GetMapping("/film-ekle2")
    public String filmEkleSayfasi2(Model model) {
        model.addAttribute("movie", new Movie());
        return "admindashboard";
    }
    
    @GetMapping("/my-movies")
    public String getMyMovies(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            List<Movie> myMovies = movieService.findByCreatedBy(username);
            model.addAttribute("movies", myMovies);
            return "myMovies.jsp";
        }
        return "redirect:/login";
    }
    

    @GetMapping("/edit")
    public String editMovie(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "editMovie.jsp";
    }
    
    @GetMapping("/edit2")
    public String editMovie2(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "editMovieAdmin.jsp";
    }

    @PostMapping("/update")
    public String updateMovie(@ModelAttribute Movie movieToUpdate) throws IOException {
        movieService.updateMovie(movieToUpdate);
        return "redirect:/my-movies";
    }
    
    @PostMapping("/update2")
    public String updateMovie2(@ModelAttribute Movie movieToUpdate) throws IOException {
        movieService.updateMovie(movieToUpdate);
        return "redirect:/movies";
    }


    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/my-movies";
    }
    
    @GetMapping("/delete2/{id}")
    public String deleteMovie2(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }


}

