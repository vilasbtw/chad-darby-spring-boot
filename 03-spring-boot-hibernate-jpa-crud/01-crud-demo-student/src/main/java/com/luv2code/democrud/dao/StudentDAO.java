package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Student;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(int id);
}
