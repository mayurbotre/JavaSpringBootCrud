package com.mayurbotre.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayurbotre.SpringBootCrud.bean.Subject;
import com.mayurbotre.SpringBootCrud.exception.EmptyInputException;
import com.mayurbotre.SpringBootCrud.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	public SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubjects(){
		List<Subject> subjects = new ArrayList<Subject>();
		subjectRepository.findAll().forEach(subjects::add);
		return subjects;
	}
	
	public Subject getSubjectById(String id) {
		return subjectRepository.findById(id).get();
	}
	
	public void addSubject(Subject subject) {
		if(subject.getName().isEmpty() || subject.getName().length()==0) {
			throw new EmptyInputException("601", "Input fields are empty");
		}
		subjectRepository.save(subject);
	}
	
	public void updateSubject( String id, Subject subject) {
		subjectRepository.save(subject);
	}
	
	public void deleteSubject(String id) {
		subjectRepository.deleteById(id);
	}
	
}
