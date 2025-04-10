package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.p1.entity.eventTypes;

@Repository
public interface eventTypesRepository extends JpaRepository<eventTypes, Long> {

}
