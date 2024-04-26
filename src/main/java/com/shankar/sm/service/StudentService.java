package com.shankar.sm.service;

import java.util.List;

import com.shankar.sm.beans.Student;

public interface StudentService {

	List<Student> loadStudents();
	int saveStudent(Student student);
	Student getStudent(int id);
	int updateStudent(Student student);
	int deleteStudent(int id);
}
