package com.example.webdevsp19s1deeshashahserverjava.model;

import java.util.*;

public class Module {
	private Integer id;
	private String title;
	List<Lesson> lessons = new ArrayList<Lesson>();
	
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Module() {
		
	}
	
	public Module(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
}
