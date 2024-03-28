package com.mayurbotre.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.mayurbotre.SpringBootCrud.bean.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String> {

}
