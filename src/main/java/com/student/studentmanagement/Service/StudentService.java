package com.student.studentmanagement.Service;

import com.student.studentmanagement.dto.StudentDto;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentRepository {

    private final List<StudentDto> list = new ArrayList<>();
    @Override
    public StudentDto create(StudentDto student) {
        StudentDto std = new StudentDto();
        std.setId(student.getId());
        std.setStudentName(student.getStudentName());
        std.setDepartment(student.getDepartment());
        std.setCourse(student.getCourse());
        list.add(std);
        return std;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return list;
    }

    @Override
    public StudentDto getStudentById(int id) {
       return null;
    }
}
