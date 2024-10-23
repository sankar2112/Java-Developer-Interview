package com.ordermgmt.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "menu_item")
public class MenuItem {

	public MenuItem(Long id, String name, Double price, Integer availableQuantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String name;
	private Double price;
	private Integer availableQuantity;
	private Category category;

}
