package com.student.studentmanagement.Service;

import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService  {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> getStudentByName(String name) {
        List<Student> allStudents = studentRepository.findAll();
        Optional<Student> foundStudent =  allStudents.stream().filter(student -> student.getStudentName().equalsIgnoreCase(name)).findFirst();
        return foundStudent;
    }


}
