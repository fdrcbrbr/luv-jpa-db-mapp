package com.fefos.luvjpadbmapp.dao;

import com.fefos.luvjpadbmapp.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstuctorById(int theId);

}
