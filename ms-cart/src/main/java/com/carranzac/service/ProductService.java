package com.carranzac.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.carranzac.model.dto.ProductResponseDto;

public interface ProductService {

	public List<ProductResponseDto> findAll();
	public ProductResponseDto findById(Long id);
	public CompletableFuture<ProductResponseDto> findByIdResilience(Long id);
	public CompletableFuture<ProductResponseDto> findByIdResilienceFallBackMethod(Long id, Throwable t);
}
