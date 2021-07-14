package com.stuartyee.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.models.Category;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findByName(String searchName);
	public List<Product> findByCategories(Category category);
	public List<Product> findAll();
	public List<Product> findByIdNotIn(List<Long> ids);
}
