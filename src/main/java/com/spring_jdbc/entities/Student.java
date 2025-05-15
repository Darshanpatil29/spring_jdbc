package com.spring_jdbc.entities;

public class Student {
	private int id;
	private String city;
	private String Name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", city=" + city + ", Name=" + Name + "]";
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}


}
