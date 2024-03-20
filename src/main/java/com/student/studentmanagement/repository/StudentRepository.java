package com.student.studentmanagement.repository;

import com.student.studentmanagement.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    StudentDto create(StudentDto student);
    List<StudentDto> getAllStudent();
    StudentDto getStudentById(int id);
}
