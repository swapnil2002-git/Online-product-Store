package com.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
