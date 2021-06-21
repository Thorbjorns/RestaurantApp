package com.example.restaurant.Controller;

import com.example.restaurant.entity.Pizza;
import com.example.restaurant.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping("/pizza")
    public String getAllPizzas(Model model){
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        model.addAttribute("pizza",pizzas);
        return "pizza";
    }

    @GetMapping("/pizza/{id}")
    public Optional<Pizza> findPizzaById(@PathVariable Long id){
        return pizzaService.findPizzaById(id);
    }

//    @GetMapping("/pizza")
//    public List<Pizza> getAllPizzas(){
//        return pizzaService.getAllPizzas();
//    }

    @PostMapping("/pizza")
    public void addPizza(@RequestBody Pizza pizza){
        pizzaService.addPizza(pizza);
    }

    @DeleteMapping("/pizza/{id}")
    public void deletePizzaById(@PathVariable Long id){
        pizzaService.deletePizzaById(id);
    }

    @PutMapping("pizza/{id}")
    public Pizza updatePizza(@RequestBody Pizza pizza, @PathVariable Long id){
       return pizzaService.updatePizza(pizza);
    }

}
