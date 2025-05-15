package com.spring_jdbc;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring_jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring_jdbc.dao"})
public class JavaConfig {
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dsObj=new DriverManagerDataSource();
		dsObj.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dsObj.setUsername("root");
		dsObj.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dsObj.setPassword("root123");
		return dsObj;
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
//	@Bean(name="studentDaoImpl")
//	public StudentDaoImpl getStudentDaoImpl() {
//		StudentDaoImpl studentDaoImpl= new StudentDaoImpl();
//		studentDaoImpl.setJdbcTemplate(getJdbcTemplate());
//		return studentDaoImpl;
//	}
	
}
