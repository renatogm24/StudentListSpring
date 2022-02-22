package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentlist.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
	
	List<Student> findAll();

}
