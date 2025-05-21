package com.soft.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }


    @PostMapping("/student")
    public Student addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setMatricule("Matricule123");
        return student;
    }
}
