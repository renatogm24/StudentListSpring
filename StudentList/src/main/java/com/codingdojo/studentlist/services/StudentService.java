package com.codingdojo.studentlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> allStudents() {
        return studentRepo.findAll();
    }
	
	public Student createStudent(Student b) {
        return studentRepo.save(b);
    }
	
	public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
}
