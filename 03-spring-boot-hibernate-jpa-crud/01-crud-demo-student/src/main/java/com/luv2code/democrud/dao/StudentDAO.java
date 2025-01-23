package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Student;
import org.springframework.context.annotation.Bean;

public interface StudentDAO {

    void save(Student student);

}
