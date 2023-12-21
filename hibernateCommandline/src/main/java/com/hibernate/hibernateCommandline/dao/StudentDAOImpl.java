package com.hibernate.hibernateCommandline.dao;

import com.hibernate.hibernateCommandline.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create a query
        //its mapping from class not database columns
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName DESC", Student.class);

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //write the query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData",
                Student.class);

        //set parameters
        query.setParameter("theData", theLastName);

        //display
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
       entityManager.merge(student);
    }

    @Transactional
    public void delete(Integer id){
        //retrieve the student
        Student student = entityManager.find(Student.class, id);

        //remove the student object
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudent() {
       int rows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
       return rows;
    }

//    @Override
//    public List<Student> findByLastName(Student theLastName) {
//        return null;
//    }

}
