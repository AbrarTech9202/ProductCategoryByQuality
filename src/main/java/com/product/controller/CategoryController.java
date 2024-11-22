package com.product.controller;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.CategoryDto;
import com.product.service.ICategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final ICategoryService categoryService;
	
	
	@PostMapping("/categories") 
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
    {
	   return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
	
	
	@GetMapping("/all-categories")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		 return ResponseEntity.ok(categoryService.getAllCategory());
	}
	
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryBycategoryId(@PathVariable long categoryId)
	{
		 return ResponseEntity.ok(categoryService.getCategoryBycategoryId(categoryId));
	}
	
	@PutMapping("/categories/{categoryId}")
	public ResponseEntity<CategoryDto> UpdateCategoryBycategoryId(@RequestBody CategoryDto categoryDto,@PathVariable long categoryId )
	{
		 return ResponseEntity.ok(categoryService.UpdateCategoryBycategoryId(categoryDto, categoryId));
				 
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategoryBycategoryId(@PathVariable long categoryId)
	{
		categoryService.deleteCategoryBycategoryId(categoryId);
		return "category deleted successfully...";
	}
	
	

}
