package com.stuartyee.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stuartyee.productsandcategories.repositories.CategoryRepository;
import com.stuartyee.productsandcategories.repositories.ProductRepository;
import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.models.Category;

@Service
public class ProductService {
	
	private ProductRepository pRepo;
	private CategoryRepository cRepo;

	public ProductService(ProductRepository pRepo, CategoryRepository cRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
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
	
	//find Products not in a given Category
	public List<Product> findProductsNotInCategory(Category category){
		//Generate a list of IDs of the Products associated with the provided category
		List<Long> prodIds = new ArrayList<>();
		for(Product product : category.getProducts()) {
			prodIds.add(product.getId());
		}
		//If on the other hand there are no products,
		//return ALL the products
		if(category.getProducts().isEmpty()) {
			return pRepo.findAll();
		} else {
			//return a list of the products not associated with this category
			return pRepo.findByIdNotIn(prodIds);
		}		
	}
	
	//find Products in a given category
	public List<Product> findProductInCategory(Category category){
		return pRepo.findByCategories(category);
	}
	
	//MVC forms will overwrite an entire object so 
	//we have to use HTML forms to add or remove products
	//to a given category. The next two methods add and remove 
	//elements from Category.products and saves the changes
	//in SQL
	public void addProductToCategory(Long prodId, Long catId) {
		//Ensure both Product and Category exist by ID
		if(pRepo.findById(prodId).isPresent() && cRepo.findById(catId).isPresent()) {
			//Add new category by ID to categories in Products
			cRepo.findById(catId).get().getProducts().add(pRepo.findById(prodId).get());
			//Save to database using CRUD method
			cRepo.save(cRepo.findById(catId).get());
		}
	}
	
	public void removeProductFromCategory(Long prodId, Long catId) {
		//Ensure both Product and Category exist by ID
		if(pRepo.findById(prodId).isPresent() && cRepo.findById(catId).isPresent()) {
			//Remove Product by ID from the Category
			cRepo.findById(catId).get().getProducts().remove(pRepo.findById(prodId).get());
			//Save to database using CRUD method
			cRepo.save(cRepo.findById(catId).get());
		}
	}
	
	
	
	
	
	

}
