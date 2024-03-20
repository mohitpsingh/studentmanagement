package com.student.studentmanagement.controller;

import com.student.studentmanagement.Service.StudentService;
import com.student.studentmanagement.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudent();
    }

    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto student) {
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable  int id) {
        return studentService.getStudentById(id);
    }
}
