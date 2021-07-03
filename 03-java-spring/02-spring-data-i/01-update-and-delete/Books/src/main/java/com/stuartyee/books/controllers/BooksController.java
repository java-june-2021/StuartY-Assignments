package com.stuartyee.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stuartyee.books.services.BookService;
import com.stuartyee.books.models.Book;

@Controller
public class BooksController {
	private final BookService bookService;
 
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
 
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
    @RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") Long index) {
        Book book = bookService.findBook(index);
        model.addAttribute("book", book);
        return "/books/showBook.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id") long id, Model model) {
        Book book = bookService.findBook(id);
        if (book != null){
            model.addAttribute("book", book);
            return "books/editBook.jsp";
        }else{
            return "redirect:/books";
        }
    }
    
    @PostMapping("/books/{id}/edit")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/editBook.jsp";
        }else{
            bookService.updateBook(id, book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }
}
