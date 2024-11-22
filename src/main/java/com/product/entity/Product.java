package com.product.entity;

import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productID; 
	
	//@Column(name="Product_Name")
	private String name; 
	
	//@Column(name="Product_Description")
	private String description;
	
	//@Column(name="Product_Price")
	private double price; 
	
	//@Column(name="Product_SalePrice")
	private double salePrice;
	
	@ManyToOne
  //  @JoinColumn(name = "category_id")
	private CategoryEntity category;

}
