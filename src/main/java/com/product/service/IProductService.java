package com.product.service;

import java.util.List;

import com.product.dto.ProductDto;
import com.product.dto.ProductResponseDto;

public interface IProductService {
	
	public ProductDto createProduct(ProductDto productDto);
	
	public List<ProductResponseDto> getAllproduct();
	
	public ProductResponseDto getProductByProductId(long productId);
	
	public ProductDto UpdateProductByProductId(ProductDto productDto,long productId );
	
	public void deleteProductByProductId(long productId);

}
