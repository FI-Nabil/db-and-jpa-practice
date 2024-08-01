package com.finabil.controller;

import com.finabil.model.Student;
import com.finabil.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JdbcController {
    private final StudentService studentService;

    public JdbcController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        // somehow save this in db
        studentService.saveStudentInDB(student);
        return new ResponseEntity<>("Student info saved successfully", HttpStatus.CREATED);
    }
    @GetMapping("/student/name/{id}")
    public ResponseEntity<?> getStudentNamebyID(@PathVariable Integer id){
        String name = studentService.getStudentNameFromDB(id);
        return  new ResponseEntity<>(name, HttpStatus.CREATED);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentbyID(@PathVariable Integer id){
        Student student = studentService.getStudentFromDB(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/student/all")
    public ResponseEntity<?> getAllStudent(){
        List<Student> studentList = studentService.getAllStudentFromDB();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
