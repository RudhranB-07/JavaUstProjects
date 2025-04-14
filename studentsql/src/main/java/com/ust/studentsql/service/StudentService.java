package com.ust.studentsql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.studentsql.entity.StudentEntity;
import com.ust.studentsql.repository.StudentRepo;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepo.findAll();
    }

    public StudentEntity addStudent(StudentEntity student) {
        return studentRepo.save(student);
    }
}
