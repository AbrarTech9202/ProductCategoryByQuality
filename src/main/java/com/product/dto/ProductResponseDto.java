package com.product.dto;

import java.util.Locale.Category;

import com.product.entity.CategoryEntity;

import lombok.Data;

@Data
public class ProductResponseDto {
	
	    private long productID; 
	 	
		private String name; 
		
		private String description;
		
		private double price; 
		
		private double salePrice;
		private CategoryEntity category;


}
