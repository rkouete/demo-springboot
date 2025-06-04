package com.soft.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class Controller {

    final StudentRepository studentRepository;

    public Controller(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @GetMapping
    public ResponseEntity<List<Student> > getAllStudents() {
         return new ResponseEntity<>( studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }


    @PostMapping
    public  ResponseEntity<Student > addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setMatricule("Matricule123");

       Student studentdb=studentRepository.save(student);

        return new ResponseEntity<>(studentdb, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<Student > getPersonById(@PathVariable  Long id) {
        Optional<Student> studentdb= studentRepository.findById(id);
        if(studentdb.isPresent()){
            return new ResponseEntity<>(studentdb.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void > getDeleleStudent(@PathVariable  Long id) {
        Optional<Student> studentdb= studentRepository.findById(id);
        if(studentdb.isPresent()){
            studentRepository.delete(studentdb.get());
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    // Implement the update method here
}
