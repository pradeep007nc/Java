package com.hibernate.hibernateCommandline.dao;

import com.hibernate.hibernateCommandline.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAllStudent();

}

