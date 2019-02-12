package com.example.webdevsp19s1deeshashahserverjava.model;

public class ParagraphWidget extends Widget{
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public ParagraphWidget() {
		
	}
	
	public ParagraphWidget(Integer id, String name, String type, String text) {
		super(id, name, type);
		this.text = text;
	}
	
}
