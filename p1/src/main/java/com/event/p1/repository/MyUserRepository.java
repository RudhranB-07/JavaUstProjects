package com.event.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.p1.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {

}
