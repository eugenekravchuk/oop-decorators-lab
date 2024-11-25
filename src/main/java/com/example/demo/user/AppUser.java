package com.example.demo.user;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false) 
    private String email; 

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "dob")
    private LocalDate dob;

    @Transient
    private int age;

    public AppUser(int id, String email, LocalDate dob, int age) {
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
    

    public AppUser() {
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
