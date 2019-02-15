package com.example.webdevsp19s1deeshashahserverjava.model;
import java.util.*;
public class User {
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private List<Course> authoredCourses = new ArrayList<Course>();
	private String phone;
	private String email;
	
	public User() {}
	
	public User(int id, String username, String password, String firstName, String lastName, String role, String phone, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone=phone;
		this.email=email;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}

	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}