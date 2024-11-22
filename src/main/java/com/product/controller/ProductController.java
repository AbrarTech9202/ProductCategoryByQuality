package com.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.product.dto.ProductDto;
import com.product.dto.ProductResponseDto;
import com.product.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	
	private final IProductService productService;
	
	
	@PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
    {
		return ResponseEntity.ok(productService.createProduct(productDto));
    }
	
	@GetMapping("/all-product")
	public ResponseEntity<List<?>> getAllproduct()
	{
		return ResponseEntity.ok(productService.getAllproduct());
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductResponseDto> getProductByProductId(@PathVariable long productId)
	{
		return ResponseEntity.ok(productService.getProductByProductId(productId));
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<ProductDto> UpdateProductByProductId(@RequestBody ProductDto productDto,@PathVariable long productId )
	{
		return ResponseEntity.ok(productService.UpdateProductByProductId(productDto, productId));
	}
	
	@DeleteMapping("/product/{productId}")
	public String deleteProductByProductId(@PathVariable long productId)
	{
		productService.deleteProductByProductId(productId);
		return "product deleted successfully...";
	}

}
