package com.finabil.jpapractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity // this helps in creating table
public class Student {
    @Id
    private Integer id;
    private String name;
    private String gender;
}
