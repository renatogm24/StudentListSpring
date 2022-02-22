package com.codingdojo.studentlist.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentlist.models.Class;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.services.ClassService;
import com.codingdojo.studentlist.services.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	private StudentService studentServ;
	
	@Autowired
	private ClassService classServ;

	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,@ModelAttribute("student") Student student, @ModelAttribute("classObj") Class classObj) {
		List<Class> classes = classServ.allClasses();		
		model.addAttribute("classes", classes);
		
		List<Student> students = studentServ.allStudents();		
		model.addAttribute("students", students);
		
		return "dashboard.jsp";
	}
	
	@RequestMapping(value = "/classes", method = RequestMethod.POST)
	public String createClass(@Valid @ModelAttribute("classObj") Class classObj, BindingResult result, Model model, HttpSession session) {	
		
		if(result.hasErrors()) {
			model.addAttribute("classes", classServ.allClasses());
			model.addAttribute("students", studentServ.allStudents());
			model.addAttribute("student", new Student());
			return "dashboard.jsp";
		}
		
		classServ.createClass(classObj);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model, HttpSession session) {	
		
		if(result.hasErrors()) {	
			model.addAttribute("classes", classServ.allClasses());
			model.addAttribute("students", studentServ.allStudents());
			model.addAttribute("classObj", new Class());
			return "dashboard.jsp";
		}
		
		studentServ.createStudent(student);

		return "redirect:/";
	}
	
	@RequestMapping("/classes/{id}")
	public String showClass(Model model, @PathVariable("id") Long id) {
		Class classAux = classServ.findClass(id);
		model.addAttribute("classAux", classAux);
		return "class.jsp";
	}
	
	@RequestMapping("/students/{id}")
	public String showStudent(Model model, @PathVariable("id") Long id) {
		Student student = studentServ.findStudent(id);
		model.addAttribute("student", student);
		
		List<Class> classesNotSigned = classServ.findByStudentsNotContains(student);
		model.addAttribute("classesNotSigned", classesNotSigned);
		
		return "student.jsp";
	}
	
	@RequestMapping(value="/students/{id}/addClass", method = RequestMethod.POST)
	public String addClass(Model model, @PathVariable("id") Long id, @RequestParam(value="class_id") Long class_id) {
		//Product product = productServ.findProduct(id);
		classServ.addStudentToClass(class_id,id);
		return "redirect:/students/"+id;
	}
	
	@RequestMapping("/students/retirar/{id_student}/{id_class}")
	public String retirarDeClase(Model model, @PathVariable("id_student") Long id_student, @PathVariable("id_class") Long id_class) {
		Student student = studentServ.findStudent(id_student);
		Class classAux = classServ.findClass(id_class);
		
		student.getClasses().remove(classAux);
		
		studentServ.createStudent(student);	
		
		return "redirect:/students/"+student.getId();
	}
	
}
