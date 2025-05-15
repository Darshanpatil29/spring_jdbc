package com.spring_jdbc.dao;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring_jdbc.entities.Student;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		String query="insert into student(id,name,city) values (?,?,?)";
		return this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	}
	
	public int update(Student student) {
		String query="update student set name=?,city=? where id=?";
		return this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
	}
	
	public int delete(Student student) {
		String query="delete from student where id=?";
		return this.jdbcTemplate.update(query,student.getId());
	}
	
	public Student display(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl<>(Student.class);
		Student student=(Student)this.jdbcTemplate.queryForObject(query,rowMapper, studentId);
		return student;
	}
	
	public List<Student> display(){
		String query="Select * from Student";
		RowMapper rowMapper=(rs,rowNum)->{
			Student std=new Student();
			std.setId(rs.getInt(1));
			std.setName(rs.getString(2));
			std.setCity(rs.getString(3));
			return std;
		};
		return this.jdbcTemplate.query(query,rowMapper);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public StudentDaoImpl() {
		super();
	}
}
