package com.stuartyee.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stuartyee.productsandcategories.repositories.ProductRepository;
import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.models.Category;

@Service
public class ProductService {
	
	private ProductRepository pRepo;

	public ProductService(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	
	//create a new Product
	public void createProduct(Product product) {
		pRepo.save(product);
	}
	
	//update a product 
	public void updateProduct(Product product) {
		pRepo.save(product);
	}
	
	//find by ID
	public Product findProductById(Long id) {
		Optional<Product> optProduct = pRepo.findById(id);
		if(optProduct.isPresent()) {
			return optProduct.get();
		} else {
			return null;
		}
		
	}
	
	//find Products not in a given category
//	public List<Product> findProductsNotInCategory(Category category){
//		return pRepo.findByCategoriesNotIn(category.getProducts());
//	}
	
	//find Products in a given category
	public List<Product> findProductInCategory(Category category){
		return pRepo.findByCategories(category);
	}
	
	
	
	
	
	
	

}
