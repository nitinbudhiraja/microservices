package com.codingTest.studentservice.repository;

import com.codingTest.studentservice.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public String addStudent(Student student) {
        students.add(student);
        return "Success";
    }

    public String removeStudent(String studentId) {
        return students.removeIf(student -> student.getId().equals(studentId)) ? "Success" : "Record doesn't exist";
    }

    public Student getStudentInfo(String studentId) {
        Optional<Student> studentData = students.stream().filter(student -> student.getId().equals(studentId)).findFirst();
        if(studentData.isPresent()){
            return studentData.get();
        }else {
            return new Student();
        }
    }

}
