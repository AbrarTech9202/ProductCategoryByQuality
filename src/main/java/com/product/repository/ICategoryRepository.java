package com.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.CategoryEntity;


@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findByCategoryName(String categoryName);

}
