package com.student.studentmanagement.Service;

import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDecoratorService extends StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentByStudentEmailAddress(String emailAddress) {
        List<Student> allstudents = studentRepository.findAll();
        Optional<Student> foundStudent = allstudents.stream().filter(student -> student.getEmailAddress().equalsIgnoreCase(emailAddress)).findFirst();
        return foundStudent;
    }
}
