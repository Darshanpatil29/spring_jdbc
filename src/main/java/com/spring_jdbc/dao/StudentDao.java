package com.spring_jdbc.dao;

import java.util.List;

import com.spring_jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public int delete(Student student);
	public Student display(int id);
	public List<Student> display();
//	public Student display(int []id);
	
	default public void greet() {
		System.out.println("Hello Interfaces");
	}
}
