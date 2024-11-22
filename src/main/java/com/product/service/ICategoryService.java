package com.product.service;

import java.util.List;

import com.product.dto.CategoryDto;

public interface ICategoryService {
	
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategory();
	
	public CategoryDto getCategoryBycategoryId(long categoryId);
	
	public CategoryDto UpdateCategoryBycategoryId(CategoryDto categoryDto,long categoryId );
	
	public void deleteCategoryBycategoryId(long categoryId);

}
