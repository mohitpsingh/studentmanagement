package com.student.studentmanagement.Service;

import com.student.studentmanagement.dto.StudentDto;
import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student createStudent(Student student) { return studentRepository.save(student); }



}
