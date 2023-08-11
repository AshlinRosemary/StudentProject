package com.projects.studentproject.controller;

import com.projects.studentproject.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//Here passing Student class as datatype , getStudent method to get our JSOn
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(1,"Ashli",10);
        //return new ResponseEntity<>(student,HttpStatus.OK) ;
        return ResponseEntity.ok().
                header("Custom-header","ashli").
                body(student);
    }
    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){

        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Mariam",4));
        students.add(new Student(2,"Asla",5));
        students.add(new Student(3,"Rosy",7));
        students.add(new Student(4,"Mary",8));
        return ResponseEntity.ok(students);
    }
    @GetMapping("pv/{id}/{name}/{class}")
    // id is variable binded with method argument studentid
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentid,
                                       @PathVariable("name") String name,
                                       @PathVariable("class")int grade){

        Student student=new Student(studentid, name,grade);
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok(student);
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getGrade());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Sprinngboot Rest API for @PutMapping
    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentid){

        System.out.println(student.getName());
        System.out.print(student.getGrade());
        student.setId(studentid);
        return ResponseEntity.ok(student);
    }


    //Rest API for @DeleteMapping
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("ID deleted sucessfully") ;
    }
}
