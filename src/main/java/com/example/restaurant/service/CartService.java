package com.example.restaurant.service;

import com.example.restaurant.entity.Cart;
import com.example.restaurant.entity.Pizza;
import com.example.restaurant.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public void addCart(Cart cart){
        cartRepository.save(cart);
    }

    public Optional<Cart> getCartById(Long id){
        return cartRepository.findById(id);
    }

    public Cart updateCart(Cart cart){
        return cartRepository.save(cart);
    }


}
