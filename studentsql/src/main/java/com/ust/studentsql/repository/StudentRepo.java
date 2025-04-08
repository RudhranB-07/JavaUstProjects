package com.ust.studentsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.studentsql.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
}
