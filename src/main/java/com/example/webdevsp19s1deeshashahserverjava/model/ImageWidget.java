package com.example.webdevsp19s1deeshashahserverjava.model;

public class ImageWidget extends Widget{
	private String src;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	public ImageWidget() {
		
	}
	
	public ImageWidget(Integer id, String name, String type, String src) {
		super(id, name, type);
		this.src = src;
	}
}
