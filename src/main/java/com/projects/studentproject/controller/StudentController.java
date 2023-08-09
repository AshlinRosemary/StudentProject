package com.projects.studentproject.controller;

import com.projects.studentproject.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // http://localhost:8080/student/query?id=1....>> So that query parameter(query?id=1) get BIND
    // to Method argument (int id)
    @GetMapping("student/query")
    public Student studentRequestParam(@RequestParam int id){
        return new Student(id,"Nila",10);
    }
//@RequestParam String name,
//  @RequestParam int grade

/*
How to handle multiple query parameters in request url
 */
    //http://localhost:8080/student/query2?id=1&name=Ashli&grade=7
    @GetMapping("student/query2")
    public Student studentRequestParam2(@RequestParam int id,
                                        @RequestParam String name,
                                        @RequestParam int grade){
        return new Student(id,name,grade);
    }

    //RestAPI that handles @PostMapping Req
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getGrade());
        return student;
    }

    //Sprinngboot Rest API for @PutMapping
    @PutMapping("update/{id}")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentid){

        System.out.println(student.getName());
        System.out.print(student.getGrade());
        student.setId(studentid);
        return student;
    }
}
