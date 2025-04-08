package com.movies.moviessecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movies.moviessecurity.entity.MEntity;
import com.movies.moviessecurity.repository.MRepository;

@Service
public class MService {

    private final MRepository mRepository;

    public MService(MRepository mRepository) {
        this.mRepository = mRepository;
    }

    //  Get movie name by ID
    public Optional<String> getMovieNameById(Long id) {
        return mRepository.findById(id).map(MEntity::getName);
    }

    //  Get movies by genre
    public List<String> getMovieNamesByGenre(String genre) {
        return mRepository.findByGenre(genre).stream().map(MEntity::getName).toList();
    }

    //  Add new movie
    public MEntity addMovie(MEntity movie) {
        return mRepository.save(movie);
    }

    //  Get all movies
    public List<MEntity> getAllMovies() {
        return mRepository.findAll();
    }

    //  Update an existing movie
    public MEntity updateMovie(Long id, MEntity updatedMovie) {
        return mRepository.findById(id).map(movie -> {
            movie.setName(updatedMovie.getName());
            movie.setGenre(updatedMovie.getGenre());
            return mRepository.save(movie);
        }).orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));
    }

    //  Delete a movie by ID
    public String deleteMovie(Long id) {
        if (mRepository.existsById(id)) {
            mRepository.deleteById(id);
            return "Movie deleted successfully!";
        } 
        return "Movie not found!";
    }
}
