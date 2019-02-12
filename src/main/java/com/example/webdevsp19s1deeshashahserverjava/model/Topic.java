package com.example.webdevsp19s1deeshashahserverjava.model;

import java.util.*;

public class Topic {
	private Integer id;
	private String title;
	private List<Widget> widgets = new ArrayList<Widget>(); 
	
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
	
	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public Topic() {
		
	}
	
	public Topic(Integer id, String title) {
		
		super();
		this.id = id;
		this.title = title;
	}
}
