package com.example.webdevsp19s1deeshashahserverjava.model;

import java.util.*;

public class Course {
	private Integer id;
	private String title;
	private List<Module> modules = new ArrayList<Module>();
	
	
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		for(Module m : modules) {
			System.out.println("m: "+m.getTitle());
		}
		this.modules = modules;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Course() {
		
	}
	
	public Course(Integer id, String title) {
		
		super();
		this.id = id;
		this.title = title;
	}
	
	
}
