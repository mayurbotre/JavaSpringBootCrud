package com.mayurbotre.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mayurbotre.SpringBootCrud.bean.Subject;
import com.mayurbotre.SpringBootCrud.service.SubjectService;

@RestController
@RequestMapping("/api/endpoint")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/get/subjects")
	public List<Subject> getAllSubjects(){
		return subjectService.getAllSubjects();
	}
	
	@GetMapping("/get/subject/{id}")
	public Subject getSubjectById(@PathVariable String id){
		return subjectService.getSubjectById(id);
	}
	
	@PostMapping("/add/subject")
	public void addSubject(@RequestBody Subject subject) {
		subjectService.addSubject(subject);
	}
	
	@PutMapping("/update/subject/{id}")
	public void updateSubject(@PathVariable String id,@RequestBody Subject subject) {
		subjectService.updateSubject(id, subject);
	}
	
	@DeleteMapping("/delete/subject/{id}")
	public void deleteSubject(@PathVariable String id) {
		subjectService.deleteSubject(id);
	}
}
