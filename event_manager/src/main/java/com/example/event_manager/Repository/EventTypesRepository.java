package com.example.event_manager.Repository;

import com.example.event_manager.entity.EventTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypesRepository extends JpaRepository<EventTypes, Long> {

}
