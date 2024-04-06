package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class DemoappApplicationTests {
	
	@Autowired
	private  StudentRepository studentRepository;

	@Test
	void addStudent() {
		Student s= new Student();
		s.setName("Stallin");
		s.setCourse("Java");
		s.setFees(10000);
		s.setEmail("stallin@gmail.com");
		studentRepository.save(s);
	}
	
	@Test
	void deleteStudentRecord() {
		studentRepository.deleteById(2L);
	}

	
	@Test
	void getStudentRecord() {
		Optional<Student> opStudent = studentRepository.findById(1L);
		if(opStudent.isPresent()) {
			Student student = opStudent.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getEmail());
			System.out.println(student.getFees());
			
		}else {
			System.out.println("No record found!");
		}
	}
	
	@Test
	void updateStudentRecord() {
		Optional<Student> opStudent = studentRepository.findById(1L);
		if(opStudent.isPresent()) {
			Student s = opStudent.get();
			
			s.setName("mike");
			s.setCourse("Java");
			s.setFees(10000);
			s.setEmail("mike@gmail.com");
			studentRepository.save(s);
			
		}else {
			System.out.println("No record found!");
		}
	}
	
	
	@Test
	void getAllStudents() {
		Iterable<Student> students = studentRepository.findAll();
		for (Student student : students) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getEmail());
			System.out.println(student.getFees());
			
		}
		
	}
}
