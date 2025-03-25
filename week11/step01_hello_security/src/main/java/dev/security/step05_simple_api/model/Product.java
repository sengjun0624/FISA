package dev.security.step05_simple_api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}
