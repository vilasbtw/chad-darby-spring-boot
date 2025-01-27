package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}