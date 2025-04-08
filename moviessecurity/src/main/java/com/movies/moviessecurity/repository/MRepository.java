package com.movies.moviessecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.moviessecurity.entity.MEntity;

@Repository
public interface MRepository extends JpaRepository<MEntity, Long>{

	List<MEntity> findByGenre(String genre);
}
