package com.finabil.service;

import com.finabil.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final JdbcTemplate jdbctemp;

    // by this constructor, we are injecting database connection dependency to this class, now this class is connected to the database
    public StudentService(JdbcTemplate jdbcTemplate){
        this.jdbctemp = jdbcTemplate;
    }

    public void saveStudentInDB(Student student){
        // we are taking information of student from postman through JdbcController, and then inserting them in database
        String sql = "insert into students (id, name, gender) values (?, ?, ?)";
        jdbctemp.update(sql, student.getId(), student.getName(), student.getGender());
    }

    public String getStudentNameFromDB (Integer id){
        String sql = "SELECT name from students where id = ?";
        return jdbctemp.queryForObject(sql, String.class, id);
        // queryForObject return a single object
    }

    public Student getStudentFromDB(Integer id){
        String sql = "SELECT * from students where id = ?";
        return jdbctemp.queryForObject(sql, (result, rowNum) ->{
            Student student = new Student();
            student.setId(result.getInt("id"));
            student.setName(result.getString("name"));
            student.setGender(result.getString("gender"));
            return student;
        },id);
    }

    public List<Student> getAllStudentFromDB(){
        String sql = "SELECT * from students";
        return jdbctemp.query(sql, (result, rowNum) ->{
            Student student = new Student();
            student.setId(result.getInt("id"));
            student.setName(result.getString("name"));
            student.setGender(result.getString("gender"));
            return student;
        });
        // query return a list of object
    }
}
