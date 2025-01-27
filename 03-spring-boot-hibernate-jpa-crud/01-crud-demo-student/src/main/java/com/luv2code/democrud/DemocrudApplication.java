package com.luv2code.democrud;

import com.luv2code.democrud.dao.StudentDAO;
import com.luv2code.democrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			findByLastName(studentDAO);
		};
	}

	private Student createStudent(StudentDAO studentDAO) {
		Student student = new Student("Cece", "Beesly", "cbeesly@dmiffin.com");
		studentDAO.save(student);
		return student;
	}

	private void findById(StudentDAO studentDAO) {
		System.out.println("Creating a new student...");
		Student tempStudent = createStudent(studentDAO);
		int newStudentId = tempStudent.getId();
		System.out.println("New student id: " + newStudentId);
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void findByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Beesly");

		for (Student s : students) {
			System.out.println(s);
		}
	}
}