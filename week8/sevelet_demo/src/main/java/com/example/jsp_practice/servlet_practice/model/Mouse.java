package com.example.jsp_practice.servlet_practice.model;

public class Mouse {
	int id;
	
	String name;
	String country;
	String address;

	@Override
	public String toString() {
		return name + "," + country + "," + address;
	}

	public Mouse(String name, String country, String address) {
		this.name = name;
		this.country = country;
		this.address = address;
	}

	public int getId() {
		return id;
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
