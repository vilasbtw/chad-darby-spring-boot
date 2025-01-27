package com.luv2code.democrud;

import com.luv2code.democrud.dao.StudentDAO;
import com.luv2code.democrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			findById(studentDAO);
		};
	}

	private Student createStudent(StudentDAO studentDAO) {
		Student student = new Student("Kaique", "Vilas", "kvilas@unicamp.br");
		studentDAO.save(student);
		return student;
	}

	private void findById(StudentDAO studentDAO) {
		System.out.println("Creating a new student...");
		Student tempStudent = createStudent(studentDAO);
		int newStudentId = tempStudent.getId();
		System.out.println("New student id: " + newStudentId);
	}
}