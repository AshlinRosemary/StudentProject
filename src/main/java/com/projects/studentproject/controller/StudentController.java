package com.projects.studentproject.controller;

import com.projects.studentproject.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//Here passing Student class as datatype , getStudent method to get our JSOn
    @GetMapping("student")
    public Student getStudent(){
        Student student=new Student(1,"Ashli",10);
        return student;
    }
    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){

        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Mariam",4));
        students.add(new Student(2,"Asla",5));
        students.add(new Student(3,"Rosy",7));
        students.add(new Student(4,"Mary",8));
        return students;
    }
    @GetMapping("pv/{id}/{name}/{class}")
    // id is variable binded with method argument studentid
    public Student studentPathVariable(@PathVariable("id") int studentid,
                                       @PathVariable("name") String name,
                                       @PathVariable("class")int grade){
        return new Student(studentid, name,grade);
        //Id is dynamically passed to the student details , just change
        // http://localhost:8080/pv/2/Lissy/10
        /*
        JSON o/p
        {"id":2,"name":"Lissy","grade":10}
         */
    }

}
