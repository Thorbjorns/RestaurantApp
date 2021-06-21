package com.example.restaurant.service;

import com.example.restaurant.entity.Pizza;
import com.example.restaurant.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public void addPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    public void deletePizzaById(Long id) {
        pizzaRepository.deleteById(id);
    }

    public Pizza updatePizza(Pizza pizza) {
       return pizzaRepository.save(pizza);
    }

    public Optional<Pizza> findPizzaById(Long id){
        return pizzaRepository.findById(id);
    }

}
