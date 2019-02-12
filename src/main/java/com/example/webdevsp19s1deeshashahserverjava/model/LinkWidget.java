package com.example.webdevsp19s1deeshashahserverjava.model;

public class LinkWidget extends Widget{
	private String href;
	private String title;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LinkWidget() {
		
	}
	
	public LinkWidget(Integer id, String name, String type, String href, String title) {
		super(id, name, type);
		this.href = href;
		this.title = title;
	}
}
