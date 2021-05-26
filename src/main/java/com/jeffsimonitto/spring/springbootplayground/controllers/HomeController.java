package com.jeffsimonitto.spring.springbootplayground.controllers;

import com.jeffsimonitto.spring.springbootplayground.entities.Cart;
import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import com.jeffsimonitto.spring.springbootplayground.services.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class HomeController {

    private final InventoryService inventoryService;

    public HomeController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    String home(Model model) {
        model.addAttribute("items", this.inventoryService.getInventory());
        model.addAttribute("cart",
                this.inventoryService.getCart("My Cart")
                    .orElseGet(() -> new Cart("My Cart")));
        return "home";
    }

    @PostMapping("/add/{id}")
    String addToCart(@PathVariable Integer id) {
        this.inventoryService.addItemToCart("My Cart", id);
        return "redirect:/";
    }

    @PostMapping
    String createItem(@RequestBody Item newItem) {
        this.inventoryService.saveItem(newItem);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    String deleteItem(@PathVariable Integer id) {
        this.inventoryService.deleteItem(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    String search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam boolean useAnd,
            Model model) {
        model.addAttribute("results", this.inventoryService.searchByExample(name, description, useAnd));
        return "home";
    }
}
