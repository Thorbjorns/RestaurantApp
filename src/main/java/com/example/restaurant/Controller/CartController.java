package com.example.restaurant.Controller;

import com.example.restaurant.entity.Cart;
import com.example.restaurant.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart")
    public String getAllCarts(Model model){
        List<Cart> carts = cartService.getAllCarts();
        model.addAttribute("cart",carts);
        return "cart";
    }

    @PutMapping("/cart/{id}")
    public Cart updateCart(@PathVariable Long id,@RequestBody Cart cart){
        return cartService.updateCart(cart);
    }
}
