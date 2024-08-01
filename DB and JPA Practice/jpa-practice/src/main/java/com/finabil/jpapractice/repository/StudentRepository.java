package com.finabil.jpapractice.repository;

import com.finabil.jpapractice.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//    Student findBYId(Integer id);
}
