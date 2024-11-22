package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.dto.CategoryDto;
import com.product.entity.CategoryEntity;
import com.product.globalException.ResourceNotFoundexception;
import com.product.repository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
	
	private final ICategoryRepository categoryRepository;
	
	private final ObjectMapper objectMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		CategoryEntity convertValue = objectMapper.convertValue(categoryDto, CategoryEntity.class);
		CategoryEntity saveentity = categoryRepository.save(convertValue);
		return objectMapper.convertValue(saveentity, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<CategoryEntity> allenttyData = categoryRepository.findAll();
		ArrayList<CategoryDto> listofDtoCategory = new ArrayList<CategoryDto>();
		if(allenttyData != null)
		{
			for(CategoryEntity category : allenttyData)
			{
				CategoryDto convertInDto = objectMapper.convertValue(category, CategoryDto.class);
				listofDtoCategory.add(convertInDto);
				return listofDtoCategory;
			}
		}
		  throw new ResourceNotFoundexception("Data not found in db...");
	}

	@Override
	public CategoryDto getCategoryBycategoryId(long categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).get();
		if (categoryEntity == null) {
			throw new ResourceNotFoundexception("Data not found in db...");
		}
		return objectMapper.convertValue(categoryEntity, CategoryDto.class);

	}

	@Override
	public CategoryDto UpdateCategoryBycategoryId(CategoryDto categoryDto, long categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).get();
		categoryEntity.setCategoryId(categoryEntity.getCategoryId());
		if(categoryEntity != null)
		{
			CategoryEntity saveEntity = categoryRepository.save(categoryEntity);
			return objectMapper.convertValue(saveEntity, CategoryDto.class);
		}
		throw new ResourceNotFoundexception("Data not found in db...");
	}

	@Override
	public void deleteCategoryBycategoryId(long categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	
	
	

}
