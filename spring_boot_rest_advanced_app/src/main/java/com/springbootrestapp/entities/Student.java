package com.springbootrestapp.entities;

public class Student {

	private int id;
	private String name;
	private String addres;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String addres) {
		super();
		this.id = id;
		this.name = name;
		this.addres = addres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}
	
}
