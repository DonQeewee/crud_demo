package com.luv2code.cruddemo;

import Entities.Student;
import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			// TODO: Implement command line runner here
			createStudent(studentDAO);
		};
	}


	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempstudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempstudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id:" + tempstudent.getId());
	}




}
