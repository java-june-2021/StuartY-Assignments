package com.stuartyee.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findByName(String searchName);
	public List<Category> findByProducts(Product product);
	public List<Category> findAll();
	
	//NEW!!
	public List<Category> findByIdNotIn(List<Long> ids);

}
