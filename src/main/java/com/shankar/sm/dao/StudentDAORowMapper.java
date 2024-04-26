package com.shankar.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shankar.sm.beans.Student;

public class StudentDAORowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setMobile(rs.getLong(3));
		student.setCountry(rs.getString(4));
		return student;
	}

}
