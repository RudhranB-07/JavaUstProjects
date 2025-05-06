package com.example.event_manager.Repository;

import com.example.event_manager.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, String> {
}
