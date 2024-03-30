package com.mayurbotre.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mayurbotre.SpringBootCrud.bean.Subject;
import com.mayurbotre.SpringBootCrud.service.SubjectService;

@RestController
@RequestMapping("/api/endpoint")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/get/subjects")
	public ResponseEntity<List<Subject>> getAllSubjects(){
		List<Subject> subjects = subjectService.getAllSubjects();
		if(subjects.size()==0) {
			return new ResponseEntity<List<Subject>>(List.of(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
	}
	
	@GetMapping("/get/subject/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable String id){
		Subject subject = subjectService.getSubjectById(id);
		if(subject==null) {
			return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Subject>(subject, HttpStatus.FOUND);
	}
	
	@PostMapping("/add/subject")
	public ResponseEntity<Void> addSubject(@RequestBody Subject subject) {
		subjectService.addSubject(subject);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/subject/{id}")
	public ResponseEntity<Void> updateSubject(@PathVariable String id,@RequestBody Subject subject) {
		subjectService.updateSubject(id, subject);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/subject/{id}")
	public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
		subjectService.deleteSubject(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
