package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.p1.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
