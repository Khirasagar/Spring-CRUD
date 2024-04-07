package com.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	//Custom search Query
	Optional<Student> findByEmail(String email);
	List<Student> findByCourse(String courseName);
	Iterable<Student> findByCourseOrFees(String course, int fees);
	Iterable<Student> findByCourseAndFees(String course, int fees);
	boolean existsByEmail(String email);
	
	//JPQL query
	
	@Query("Select s from Student s")
	List<Student> findAllStudents();
	
	@Query("Select s from Student s where s.course=:courseName")
	List<Student> findAllStudentsByCourse(@Param("courseName") String courseName);

	@Query("Select s from Student z where z.fees=:x")
	List<Student> findAllStudentsByFee(@Param("x") int fees);
	
	@Query("Select s from Student z where z.fees=:x or  z.course:y")
	List<Student> findAllStudentsByFeeOrCourse(@Param("x") int fees , @Param("y")String courseName);
	
	@Query("Select s from Student z where z.fees=:x and  z.course:y")
	List<Student> findAllStudentsByFeeAndCourse(@Param("x") int fees , @Param("y")String courseName);
	
	
}
