package com.spring_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring_jdbc.entities.Student;
import java.util.*;

public class RowMapperImpl<T> implements RowMapper<T> {
	
	private Class<T> type;
	
	public RowMapperImpl(Class<T> type){
		this.type=type;
	}
	
	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		if(type==Student.class) {			
			Student std=new Student();
			std.setId(rs.getInt(1));
			std.setName(rs.getString(2));
			std.setCity(rs.getString(3));
			return (T)std;
		}
		return null;
	}
}
