package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.Book;
import com.example.models.CartItem;
import com.example.models.User;
import com.example.repository.BookRepository;
import com.example.repository.CartItemRepository;
import com.example.services.BookService;
import com.example.services.CartItemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
 
  @Autowired
  BookService bookservice;
  
  @Autowired
  CartItemService cartitemservice;
  
//  @GetMapping("/user")
//  public String showUserBooks(Model model) {
//   List<Book> booklist = bookservice.getBooks();
//   model.addAttribute("booklist",booklist);
//   return "showuser";
//  }
  
  @GetMapping("/user/cart")
  public String showcart(Model model) {
   List<CartItem> cartitems = cartitemservice.showCartItems();
   model.addAttribute("cartitems",cartitems);
   return "cart";
  }
  @GetMapping("/cart/add/{bookId}")
     public String addToCart(@PathVariable Integer bookId, HttpSession session) {
         User user = (User) session.getAttribute("user");
         System.out.println("After user login : " + user);
         Book book = bookservice.getBook(bookId);
         if (user != null && book != null) {
             CartItem item = new CartItem();
             item.setUser(user);
             item.setBook(book);
             item.setQuantity(1);
             cartitemservice.addCartItem(item);
         }
         return "redirect:/user";
     }
  
  
  public String showcart(HttpSession session , Model model) {
   User user = (User) session.getAttribute("user");
         model.addAttribute("cartItems", cartitemservice.findByUser(user));
         return "cart";
  }
  
  
}