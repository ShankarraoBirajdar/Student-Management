package com.shankar.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.sm.beans.Student;
import com.shankar.sm.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> loadStudents() {
		return studentDAO.loadStudents();
	}

	@Override
	public int saveStudent(Student student) {

		int noOfRecordinserted = studentDAO.saveStudent(student);

		if (noOfRecordinserted == 1) {
			System.out.println("Student data Saved ");
		} else {
			System.out.println("Student data Not Saved ");
		}
		return noOfRecordinserted;
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(id);
	}

	@Override
	public int updateStudent(Student student) {
		int noOfRecordUpdated = studentDAO.updateStudent(student);

		if (noOfRecordUpdated == 1) {
			System.out.println("Student data Updated ");
		} else {
			System.out.println("Student data Not Updated ");
		}
		return noOfRecordUpdated;
	}

	@Override
	public int deleteStudent(int id) {
		int noOfRecordDeleted = studentDAO.deleteStudent(id);

		if (noOfRecordDeleted == 1) {
			System.out.println("Student data Deleted ");
		} else {
			System.out.println("Student data Not Deleted ");
		}
		return noOfRecordDeleted;
	}

}
