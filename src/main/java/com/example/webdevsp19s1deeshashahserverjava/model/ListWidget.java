package com.example.webdevsp19s1deeshashahserverjava.model;

public class ListWidget extends Widget{
	private Integer option;
	private String items;
	
	public Integer getOption() {
		return option;
	}
	public void setOption(Integer option) {
		this.option = option;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}	
	
	public ListWidget(){
		
	}
	
	public ListWidget(Integer id, String name, String type, Integer option, String items){
		super(id, name, type);
		this.option = option;
		this.items = items;
	}
}