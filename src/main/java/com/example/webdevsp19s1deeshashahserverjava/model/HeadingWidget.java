package com.example.webdevsp19s1deeshashahserverjava.model;

public class HeadingWidget extends Widget {
	private String text;
	private int size;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public HeadingWidget() {
		
	}
	
	public HeadingWidget(Integer id, String name, String type, String text, Integer size) {
		super(id, name, type);
		this.text = text;
		this.size = size;
	}
	
	
}
