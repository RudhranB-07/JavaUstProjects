package com.ust.studentsql.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.ust.studentsql.entity.StudentEntity;
import com.ust.studentsql.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/enter")
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return studentService.addStudent(student);
    }
}
