package com.thinkitive.practice2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// This class is mapped to the "students" table in the database
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id is auto-increment
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String course;

    // Soft delete flag: false = active student, true = deleted student
    private boolean deleted = false;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }
}
