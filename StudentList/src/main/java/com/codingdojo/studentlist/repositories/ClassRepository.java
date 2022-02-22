package com.codingdojo.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.Student;

public interface ClassRepository extends CrudRepository<Class,Long> {

	List<Class> findAll();
	
	List<Class> findByStudentsNotContains(Student student);
	
}
