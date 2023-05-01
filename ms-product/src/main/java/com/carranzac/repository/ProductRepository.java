package com.carranzac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carranzac.model.entity.CategoryEntity;
import com.carranzac.model.entity.DeletedProduct;
import com.carranzac.model.entity.ProductEntity;
import com.carranzac.model.entity.ProductStatus;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	
	@Query("from ProductEntity where deleted = com.carranzac.model.entity.DeletedProduct.CREATED and ((:status is null) or (status = :status))")
	List<ProductEntity> findAll(@Param("status") ProductStatus status);
	
	List<ProductEntity> findByCategoryAndDeleted(CategoryEntity category, DeletedProduct deleted);

}
