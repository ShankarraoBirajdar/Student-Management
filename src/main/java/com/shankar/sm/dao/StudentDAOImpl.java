package com.shankar.sm.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shankar.sm.beans.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
//		List<Student> studentList = new ArrayList<Student>();

		String selectSQL = "SELECT * FROM STUDENTS";

		// Method 1
//		List<Map<String, Object>> studList = jdbcTemplate.queryForList(selectSQL);
//		List<Student> slist = new ArrayList<>(); 
//		studList.forEach(m->{
//			Student student = new Student();
//			student.setId((Integer)m.get("id"));
//			student.setName((String)m.get("name"));
//			student.setMobile((Long)m.get("mobile"));
//			student.setCountry((String)m.get("country"));
//			slist.add(student);
//		});

		// Method 2
		List<Student> studentList = jdbcTemplate.query(selectSQL, new StudentDAORowMapper());

		return studentList;
	}

	@Override
	public int saveStudent(Student student) {

		String insertSQL = "INSERT INTO STUDENTS(NAME, MOBILE, COUNTRY) VALUES(?,?,?)";
		Object[] arr = { student.getName(), student.getMobile(), student.getCountry() };
		return jdbcTemplate.update(insertSQL, arr);

	}

	@Override
	public Student getStudent(int id) {
		String selectSQL = "SELECT * FROM STUDENTS WHERE ID = ?";
		
		Student student = jdbcTemplate.queryForObject(selectSQL, new StudentDAORowMapper(),id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		
		String updateSQL = "UPDATE STUDENTS SET NAME = ?, MOBILE = ?, COUNTRY = ? WHERE ID = ?";
		Object[] arr = { student.getName(), student.getMobile(), student.getCountry(), student.getId() };
		return jdbcTemplate.update(updateSQL, arr);
	}

	@Override
	public int deleteStudent(int id) {
		String deleteSQL = "DELETE FROM STUDENTS WHERE ID = ?";
		return jdbcTemplate.update(deleteSQL, id);
	}

}
