package com.train.service.struts.model;

public class Book {
	private Integer id;
	private String name;
	private double price;

	
	public Book(Integer id, String name,double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Book() {
	}
	// id 属性的 setter 和 getter 方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}