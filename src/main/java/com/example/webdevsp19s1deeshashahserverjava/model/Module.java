package com.example.webdevsp19s1deeshashahserverjava.model;

public class Module {
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

	public Module() {
		
	}
	
	public Module(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
}
