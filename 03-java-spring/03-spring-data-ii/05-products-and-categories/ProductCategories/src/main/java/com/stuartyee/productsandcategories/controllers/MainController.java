package com.stuartyee.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuartyee.productsandcategories.models.Category;
import com.stuartyee.productsandcategories.models.Product;
import com.stuartyee.productsandcategories.services.CategoryService;
import com.stuartyee.productsandcategories.services.ProductService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {
	@Autowired
	private ProductService pServ;
	@Autowired
	private CategoryService cServ;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	//The following @GetMapping and @PostMapping pair correspond to newProduct.jsp
	//for new Product creation
	@GetMapping("/products/new")
	public String goNewProducts(@ModelAttribute("newProduct") Product product) {
		return "newProduct.jsp"; 
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			pServ.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	//The following @GetMapping and @PostMapping pair correspond to newCategory.jsp
	//and for Category creation
	@GetMapping("/categories/new")
	public String goNewCategories(@ModelAttribute("newCategory") Category category) {
		return "newCategory.jsp"; 
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			cServ.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	//Load Product page with list of categories with ability to add categories to that product
	@GetMapping("/products/{id}")
	public String editProduct(Model model, @PathVariable("id") Long id) {
		if(pServ.findProductById(id) == null) {
			return "redirect:/products/new";
		} else {
			model.addAttribute("productname", pServ.findProductById(id).getName());
			model.addAttribute("productCategories", pServ.findProductById(id).getCategories());
			model.addAttribute(
					"notCategories",
					cServ.findCategoryNotInProduct(pServ.findProductById(id))
					);
			model.addAttribute("id", id);
			return "product.jsp";
		}
	}
	
	@PostMapping("/products/{id}")
	public String updateProduct(
			@PathVariable("id") Long prodId,
			@RequestParam(value="category") String catIdString
			) {
		Long catId = Long.valueOf(catIdString);
			
		cServ.addCategoryToProduct(catId, prodId);
		return "redirect:/products/{id}";
	}
	
	@PostMapping("/products/{id}/delete")
	public String deleteCatFromProd(
			@PathVariable("id") Long prodId,
			@RequestParam("removeCat") String idString) {
		Long catId = Long.valueOf(idString);
		cServ.removeCategoryFromProduct(catId, prodId);
		
		return "redirect:/products/{id}";
	}
	
	//Get Mapping to load Category page with products, Post mapping
	//to add Products currently not in the category
	//and a Post Mapping to remove products
	
	@GetMapping("/categories/{id}")
	public String editCategory(Model model, @PathVariable("id") Long id) {
		if(cServ.findCategoryById(id) == null) {
			return "redirect:/categories/new";
		} else {
			model.addAttribute("categoryname", cServ.findCategoryById(id).getName());
			model.addAttribute("products", cServ.findCategoryById(id).getProducts());
			model.addAttribute(
					"notProducts",
					pServ.findProductsNotInCategory(cServ.findCategoryById(id))
					);
			model.addAttribute("id", id);
			return "category.jsp";
		}
	}
	
	@PostMapping("/categories/{id}")
	public String updateCategory(
			@PathVariable("id") Long catId,
			@RequestParam(value="product") String prodIdString
			) {
		Long prodId = Long.valueOf(prodIdString);
			
		pServ.addProductToCategory(prodId, catId);
		return "redirect:/categories/{id}";
	}
	
	@PostMapping("/categories/{id}/delete")
	public String deleteProdFromCat(
			@PathVariable("id") Long catId,
			@RequestParam("removeProd") String idString) {
		Long prodId = Long.valueOf(idString);
		pServ.removeProductFromCategory(prodId, catId);
		
		return "redirect:/categories/{id}";
	}
	
	

}
