package com.student.studentmanagement.Service;

import com.student.studentmanagement.dto.StudentDto;
import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) { return studentRepository.save(student); }



}
