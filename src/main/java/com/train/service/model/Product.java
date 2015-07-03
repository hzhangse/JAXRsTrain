package com.train.service.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	public Product() {
		System.out.println("construct: Product() is called!");
	}
	
	public Product(String name) {
		System.out.println("construct: Product(String name) is called!");
		this.productName = name;
	}

	@XmlElement
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	private String productName;

}
