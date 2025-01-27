package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Annotation for DAOs. Interfaces that communicates with the database. "Sub-annotation for @Component".
@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // Injecting the EntityManager into StudentDAOImpl.
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // @Transactional assures to start and finish a query appropriately.
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // @Transaction is not needed when the database structure is modified.
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);
        query.setParameter("theData", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}