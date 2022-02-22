package com.codingdojo.studentlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.ClassRepository;
import com.codingdojo.studentlist.repositories.StudentRepository;

@Service
public class ClassService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ClassRepository classRepo;
	
	public List<Class> allClasses() {
        return classRepo.findAll();
    }
	
	public List<Class> findByStudentsNotContains(Student student) {
        return classRepo.findByStudentsNotContains(student);
    }
	
	public Class createClass(Class b) {
        return classRepo.save(b);
    }
	
	public Class findClass(Long id) {
        Optional<Class> optionalClass = classRepo.findById(id);
        if(optionalClass.isPresent()) {
            return optionalClass.get();
        } else {
            return null;
        }
    }
	
	public Class addStudentToClass(Long classId, Long studentId) {
		Class thisClass = classRepo.findById(classId).get();
		Student thisStudent = studentRepo.findById(studentId).get();
		thisClass.getStudents().add(thisStudent);		
		return classRepo.save(thisClass);
    }
	
	
}
