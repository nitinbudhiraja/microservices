package com.codingTest.studentservice.resources;

import com.codingTest.studentservice.model.Student;
import com.codingTest.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResources {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
        return studentRepository.addStudent(student);
    }

    @RequestMapping(value = "/remove/{studentId}", method = RequestMethod.DELETE)
    public String removeStudent(@PathVariable("studentId") String studentId){
        return studentRepository.removeStudent(studentId);
    }

    @RequestMapping(value = "/getById/{studentId}", method = RequestMethod.GET)
    public Student getStudentInfo(@PathVariable("studentId") String studentId){
        return studentRepository.getStudentInfo(studentId);
    }
}
