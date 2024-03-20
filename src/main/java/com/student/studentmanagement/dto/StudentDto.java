package com.student.studentmanagement.dto;

public class StudentDto {
    private int Id;
    private String studentName;
    private String department;
    private String course;

    public StudentDto(int id, String studentName, String department, String course) {
        Id = id;
        this.studentName = studentName;
        this.department = department;
        this.course = course;
    }

    public StudentDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
