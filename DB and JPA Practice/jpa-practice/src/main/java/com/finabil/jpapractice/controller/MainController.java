package com.finabil.jpapractice.controller;

import com.finabil.jpapractice.model.Student;
import com.finabil.jpapractice.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudentsFromDB();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById (@PathVariable Integer id){
        return studentService.getStudentFromDB(id);
    }

    @PostMapping("/student")
    public void getStudentById (@RequestBody Student student){
        studentService.saveStudentInDB(student);
    }
}
