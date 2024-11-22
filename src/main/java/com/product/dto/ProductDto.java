package com.product.dto;

import java.util.Locale.Category;

import com.product.entity.CategoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
    private long productID; 
 	
	private String name; 
	
	private String description;
	
	private double price; 
	
	private double salePrice;
	private String categoryName;
	private CategoryEntity category;

	

	
	

}
