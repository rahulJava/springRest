package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List thesStudents;
	
	//define @PostConstruct called only once
	
	@PostConstruct
	public void loadData()
	{
		thesStudents= new ArrayList<Student>();
		thesStudents.add(new Student("Siya Ram Ji","Mata Sita Ji"));
		thesStudents.add(new Student("Hanuman Ji","Laxman Ji"));
		thesStudents.add(new Student("Jai Maa Rani","Jai Maa Sita"));
	}
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		
		
		return thesStudents;
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudentsbyID(@PathVariable int studentID)
	{
		
		if(studentID>thesStudents.size()|| studentID<0 )
		{
			throw new StudentNotFoundException("student not found"+studentID);
		}
			return  (Student) thesStudents.get(studentID);
	}
	
}
