package com.movies.moviessecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.moviessecurity.entity.MEntity;
import com.movies.moviessecurity.service.MService;

@RestController
@RequestMapping("/movies")
public class MController {

    private final MService mService;

    public MController(MService mService) {
        this.mService = mService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to Movie Database!";
    }

    //  Get movie name by ID
    @GetMapping("/name/{id}")
    public Optional<String> getMovieNameById(@PathVariable Long id) {
        return mService.getMovieNameById(id);
    }

    //findBy[field-name] e.g. findById(), only available for primary key fields.
    
    //  Get all movie names by genre
    @GetMapping("/genre/{genre}")
    public List<String> getMovieNamesByGenre(@PathVariable String genre) {
        return mService.getMovieNamesByGenre(genre);
    }

    //  Add new movie
    @PostMapping("/add")
    public MEntity addMovie(@RequestBody MEntity movie) {
        return mService.addMovie(movie);
    }

    //  Get all movies
    @GetMapping("/all")
    public List<MEntity> getAllMovies() {
        return mService.getAllMovies();
    }

    //  Update existing movie
    @PutMapping("/update/{id}")
    public MEntity updateMovie(@PathVariable Long id, @RequestBody MEntity updatedMovie) {
        return mService.updateMovie(id, updatedMovie);
    }

    // Delete movie by ID
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        return mService.deleteMovie(id);
    }
}
