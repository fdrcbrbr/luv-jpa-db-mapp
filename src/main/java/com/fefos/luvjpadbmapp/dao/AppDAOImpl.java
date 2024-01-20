package com.fefos.luvjpadbmapp.dao;

import com.fefos.luvjpadbmapp.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstuctorById(int theId) {
        Instructor myInstructor = entityManager.find(Instructor.class, theId);

        entityManager.remove(myInstructor);
    }
}
