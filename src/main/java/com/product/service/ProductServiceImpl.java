package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.dto.ProductDto;
import com.product.dto.ProductResponseDto;
import com.product.entity.CategoryEntity;
import com.product.entity.Product;
import com.product.globalException.ResourceNotFoundexception;
import com.product.repository.ICategoryRepository;
import com.product.repository.IProductRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements IProductService {
	
	
	private final ObjectMapper objectMapper;
	
	private final IProductRespository productRespository;
	
	private final ICategoryRepository categoryRepository;

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		Product convertInEntity = objectMapper.convertValue(productDto, Product.class);
		CategoryEntity category = categoryRepository.findByCategoryName(productDto.getCategoryName());
		convertInEntity.setCategory(category);
		Product saveentity = productRespository.save(convertInEntity);
		return objectMapper.convertValue(saveentity, ProductDto.class);
	}

	@Override
	public List<ProductResponseDto> getAllproduct() {

		List<Product> allData = productRespository.findAll();
		ArrayList<ProductResponseDto> listofDto = new ArrayList<ProductResponseDto>();
		if (allData != null) {
			for (Product product : allData) {
				ProductResponseDto convertInDto = objectMapper.convertValue(product, ProductResponseDto.class);
				listofDto.add(convertInDto);
				return listofDto;
			}
		}
		throw new ResourceNotFoundexception("Data not found in db...");
	}

	@Override
	public ProductResponseDto getProductByProductId(long productId) {

		Product product = productRespository.findById(productId).get();
		if (product == null) {
			throw new ResourceNotFoundexception("Data not found in db...");
		}
		return objectMapper.convertValue(product, ProductResponseDto.class);
	}

	@Override
	public ProductDto UpdateProductByProductId(ProductDto productDto, long productId) {

		Product product = productRespository.findById(productId).get();
		product.setProductID(product.getProductID());
		if (product != null) {
			Product saveentity = productRespository.save(product);
			return objectMapper.convertValue(saveentity, ProductDto.class);
		}

		throw new ResourceNotFoundexception("Data not found in db...");
	}

	@Override
	public void deleteProductByProductId(long productId) {

		productRespository.deleteById(productId);

	}

}
