package com.example.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Book;
import com.example.models.User;
import com.example.services.BookService;
import com.example.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	BookService bookservice;
	
	@Autowired
	UserService userservice;
	
	List<Book> booklist=null;
	
	 @GetMapping("/")
	 public String showBooks(Model model) {
	  booklist = bookservice.getBooks();
	  model.addAttribute("booklist",booklist);
	  return "index";
	 }
	
	@GetMapping("/admin")
	public String showAdminBooks(Model model) {
		booklist = bookservice.getBooks();
		model.addAttribute("booklist",booklist);
		return "show";
	}
	 @GetMapping("/user")
	 public String showUserBooks(Model model, HttpSession session) {
	  booklist = bookservice.getBooks();
	  model.addAttribute("booklist",booklist);
	  User user = (User) session.getAttribute("user");
	  model.addAttribute("user",user);
	  return "showuser";
	 }
	
	@GetMapping("/add")
	public String addBook(Model model ) {
		Book book = new Book();
		model.addAttribute("book",book);
		bookservice.addBook(book);
		return "add";
	}
	
	@PostMapping("/book/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookservice.addBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		bookservice.deleteBook(id);
		return "redirect:/";
	}
	
	 @GetMapping("/userlogin")
	 public String login(Model model) {
	  model.addAttribute("user", new User());
	  return "login";
	 }

	 @GetMapping("/login")
	 public String validateuser(@RequestParam String username, @RequestParam String password) {
	  User user1 = userservice.getUser(username, password);
	  //System.out.println(user1);
	  if(user1==null)
	   return "login";
	  else
	   return"redirect:/user";
	 }
	 @GetMapping("/register")
	 public String userregister(Model model) {
	  model.addAttribute("user",new User());
	  return "registration";
	 }
	 
	
	 @PostMapping("/user/save")
	 public String userRegister(@ModelAttribute("user") User user) {
	  userservice.addUser(user);
	  return "login";
	 }
	
	 @GetMapping("/search")
	 public String getById(Model model, @RequestParam String bookid) {
	  //System.out.println(bookid);
	  Integer id = Integer.parseInt(bookid);
	  Book book=bookservice.getBook(id);
	  model.addAttribute("book",book);
	  return "showbook";
	 }
	
	
	 @GetMapping("/getbooks/{type}")
	 public String getBooks(Model model, @PathVariable String type) {
	  booklist = bookservice.getBooksByType(type);
	  model.addAttribute("booklist",booklist);
	  return "show";
	 }
	 
	 
	 @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable int id, Model model) {
	        Book book = bookservice.getBook(id);
	        model.addAttribute("book", book);
	        return "editbook";
	    }
	 
	  @PostMapping("/update")
	     public String updateBook(@ModelAttribute Book book) {
	         bookservice.updateBook(book);
	         return "redirect:/";
	  }
	 
	 @GetMapping("/about")
	    public String aboutPage() {
	        return "about"; 
	    }
	 
	  @GetMapping("/contact")
	    public String contactPage() {
	        return "contact";
	    }
	 

	 
	  @GetMapping("/searchbyprice")
	  public String findbyprice(Model model, @RequestParam String price1, @RequestParam String  price2){
	   List booklist = bookservice.getBooks();
	   List bookpricelist=new ArrayList<Book>();
	   Iterator<Book> i1 = booklist.iterator();
	   int p1 = Integer.parseInt(price1);
	   int p2 = Integer.parseInt(price2);
	   while(i1.hasNext()) {
	    Book b1 = i1.next();
	    if(b1.getPrice()>=p1 && b1.getPrice()<=p2) {
	     bookpricelist.add(b1);
	    }
	   }
	   model.addAttribute("booklist",bookpricelist);
	   return "show";
	  }
	
	 
		
	 @GetMapping("/gallery")
	    public String showGallery(Model model) {
	        String[] images = {
	            "/images/book1.jpeg",
	            "/images/book2.jpeg",
	            "/images/book3.jpeg",
	            "/images/book4.jpeg",
	            "/images/book 5.jpeg",
	            "/images/Harrypottar.jpeg"
	        };

	        model.addAttribute("images", images);
	        return "gallery"; 
	    } 
	 
}
