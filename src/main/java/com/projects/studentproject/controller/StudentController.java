package com.projects.studentproject.controller;

import com.projects.studentproject.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
//Here passing Student class as datatype , getStudent method to get our JSOn
    @GetMapping("student")
    public Student getStudent(){
        Student student=new Student(1,"Ashli",10);
        return student;
    }

}
