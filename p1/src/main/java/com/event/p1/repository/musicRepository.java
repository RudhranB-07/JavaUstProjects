package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.p1.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
