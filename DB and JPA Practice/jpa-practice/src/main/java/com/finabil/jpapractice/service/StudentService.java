package com.finabil.jpapractice.service;

import com.finabil.jpapractice.model.Student;
import com.finabil.jpapractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudentsFromDB(){
        return studentRepository.findAll();
    }
    public Student getStudentFromDB(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null);
    }
    public void saveStudentInDB(Student student){
        studentRepository.save(student);
    }

}
