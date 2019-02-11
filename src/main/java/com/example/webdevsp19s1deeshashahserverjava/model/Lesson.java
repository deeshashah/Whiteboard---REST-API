package com.example.webdevsp19s1deeshashahserverjava.model;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
	private Integer id;
	private String title;
	
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

	public Lesson() {
		
	}
	
	public Lesson(Integer id, String title) {
		
		super();
		this.id = id;
		this.title = title;
	}
	
	
}
