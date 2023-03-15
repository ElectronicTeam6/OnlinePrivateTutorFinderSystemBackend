package com.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entity.Books;
import com.optfs.exception.NullUserFound;
import com.optfs.service.BookService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BookService booksService;
	
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Books controller";
	}
	
	@PostMapping("/registerBooks")
	public Books registerBooks(@RequestBody Books books) throws NullUserFound {
		return booksService.registerBooks(books);
	}
	
	@GetMapping("/allBooks")
	public List<Books> getAllBookss(){
		return booksService.getAllBookss();
	}
	
	@PutMapping("/updateBook")
	public Books updateBooks(@RequestBody Books books) throws NullUserFound {
		return booksService.updateBooks(books);
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBooks(@RequestBody Books books) throws NullUserFound {
		return booksService.deleteBooks(books);
	}
	
}