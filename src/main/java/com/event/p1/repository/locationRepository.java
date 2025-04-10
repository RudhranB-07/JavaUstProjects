package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.p1.entity.location;

public interface locationRepository extends JpaRepository<location, Long> {
}
