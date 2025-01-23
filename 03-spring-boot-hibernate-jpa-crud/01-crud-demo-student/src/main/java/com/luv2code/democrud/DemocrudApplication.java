package com.luv2code.democrud;

import com.luv2code.democrud.dao.StudentDAO;
import com.luv2code.democrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student student = new Student("Kaique", "Vilas", "kvilas@unicamp.br");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println("Saved student. Generated ID: " + student.getId());
	}
}