package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.p1.entity.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {

}
