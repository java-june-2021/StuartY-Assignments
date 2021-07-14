package com.stuartyee.productsandcategories.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.stuartyee.productsandcategories.repositories.CategoryRepository;
import com.stuartyee.productsandcategories.repositories.ProductRepository;
import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.models.Category;

@Service
public class CategoryService {
	
	private CategoryRepository cRepo;
	private ProductRepository pRepo;

	public CategoryService(CategoryRepository cRepo, ProductRepository pRepo) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
		
	}
	
	//create a new Category
	public void createCategory(Category category) {
		cRepo.save(category);
	}
	
	//update a product with a new Product
	public void updateCategory(Category category) {
		cRepo.save(category);
	}
	
	//find by ID
	public Category findCategoryById(Long id) {
		Optional<Category> optCat = cRepo.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		} else {
			return null;
		}		
	}
	
	//find Categories not in a given Product
	public List<Category> findCategoryNotInProduct(Product product){
		//Generate list of IDs for the categories within the given Product
		List<Long> catIds = new ArrayList<>();
		for(Category category : product.getCategories()) {
			catIds.add(category.getId());
		}
		//If a given product doesn't have any categories, return all the
		//categories by default
		if(product.getCategories().isEmpty()) {
			return cRepo.findAll();
		} else {
			//the list of ALL categories not associated with this product
			return cRepo.findByIdNotIn(catIds);
		}		
	}
	
	//find Categories in a given Product
	public List<Category> findCategoryInProduct(Product product){
		return cRepo.findByProducts(product);
	}
	
	//MVC forms will overwrite an entire object so 
	//we have to use HTML forms to add or remove categories
	//to a given product. The next two methods add and remove 
	//elements from Product.categories and saves the changes
	//in SQL
	public void addCategoryToProduct(Long catId, Long prodId) {
		//Ensure both Product and Category exist by ID
		if(pRepo.findById(prodId).isPresent() && cRepo.findById(catId).isPresent()) {
			//Add new category by ID to categories in Products
			pRepo.findById(prodId).get().getCategories().add(cRepo.findById(catId).get());
			//Save to database using CRUD method
			pRepo.save(pRepo.findById(prodId).get());
		}
	}
	
	public void removeCategoryFromProduct(Long catId, Long prodId) {
		//Ensure both Product and Category exist by ID
		if(pRepo.findById(prodId).isPresent() && cRepo.findById(catId).isPresent()) {
			//Remove category by ID from the Product
			pRepo.findById(prodId).get().getCategories().remove(cRepo.findById(catId).get());
			//Save to database using CRUD method
			pRepo.save(pRepo.findById(prodId).get());
		}
	}
	
	
}
