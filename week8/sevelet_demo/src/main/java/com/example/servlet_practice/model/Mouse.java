package com.example.servlet_practice.model;

public class Mouse {
	String name;
	String country;
	String address;

	public Mouse(String name, String country, String address) {
		this.name = name;
		this.country = country;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}
}
