package com.student.studentmanagement.controller;

import com.student.studentmanagement.Service.StudentDecoratorService;
import com.student.studentmanagement.Service.StudentService;
import com.student.studentmanagement.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@RestControllerAdvice
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDecoratorService studentDecoratorService;

    @ExceptionHandler(Exception.class)
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        LOGGER.info("Fetching all students...");
        List<Student> students = studentService.getAllStudents();
        LOGGER.debug("Retrieved {} students", students.size());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        LOGGER.info("Saving student: {}", student);
        Student saveStudent = studentService.saveStudent(student);
        LOGGER.info("Student saved successfully with ID: {}", saveStudent.getId());
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")  Long id) {
        LOGGER.info("Fetching student by ID: {}", id);
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            LOGGER.warn("Student not found with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("studentName/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name) {
        try {
            Optional<Student> student = studentService.getStudentByName(name);
            if (student.isPresent()) {
                return new ResponseEntity<>(student.get(), HttpStatus.OK);
            }

        } catch(Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("studentEmailAddress/{emailAddress}")
    public ResponseEntity<Student> getStudentByEmailAddress(@PathVariable("emailAddress") String emailAddress) throws Exception {
        Optional<Student> student = studentDecoratorService.getStudentByStudentEmailAddress(emailAddress);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
