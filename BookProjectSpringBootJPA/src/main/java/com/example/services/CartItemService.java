package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.CartItem;
import com.example.models.User;
import com.example.repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	public void addCartItem(CartItem cartitem) {
		cartItemRepository.save(cartitem);
	}
	
	public void deleteCartItem(CartItem cartitem) {
		cartItemRepository.delete(cartitem);
	}
	
	public List<CartItem> showCartItems() {
		List<CartItem> cartitems = cartItemRepository.findAll();
		return cartitems;
	}

	public User findByUser(User user) {
		User user1 = (User) cartItemRepository.findByUser(user);
		return user1;
	}

}

