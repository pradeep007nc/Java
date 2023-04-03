package com.hibernate.hibernateCommandline;

import com.hibernate.hibernateCommandline.dao.StudentDAO;
import com.hibernate.hibernateCommandline.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCommandlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCommandlineApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd(StudentDAO studentDAO){
		return runner-> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryStudents(studentDAO);
			queryByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
       int numRows = studentDAO.deleteAllStudent();
		System.out.println("rows deleted "+numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 8;
		System.out.println("id to be deleted "+studentId);
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
       int studentId = 1;
		System.out.println("getting student by id "+studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("change name to scooby");
		student.setFirstName("pradeep");
		studentDAO.update(student);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		//get the list of data from the fetched query
		List<Student> list = studentDAO.findByLastName("naidu");

		//display
		for (Student student: list){
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> list = studentDAO.findAll();

		//display the list of students
		for (Student stu: list){
			System.out.println(stu);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student student = new Student("daffy", "duck", "mama_mia@gmial.com");
		//save the student
		studentDAO.save(student);
		//retrieve id
		int id = student.getId();
		System.out.println("the id of the student is "+id);
		//display the student
		Student myStudent = studentDAO.findById(id);
		System.out.println("the student is found "+myStudent);
		System.out.println(student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple student
		//save the student object
		Student tempStudent1 = new Student("pradeep", "naidu", "pradeeppilli134@gmail.com");
		Student tempStudent2 = new Student("zala", "bibek", "zallu@123gmail.com");
		Student tempStudent3 = new Student("bisnu", "chootiya", "bisnu@gmail.com");
		System.out.println("saving the objects");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){

		//create student object
		System.out.println("creating the student object");
		Student tempStudent = new Student("pradeep", "naidu", "pradeeppilli134@gmail.com");

		//save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		//display the id of the student object
		System.out.println(tempStudent.getId()+" is the id of the student");
	}

}
