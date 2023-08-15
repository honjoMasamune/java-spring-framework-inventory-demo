package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyProductController {

    private final ProductService productService;

    @Autowired
    public BuyProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/buyProduct")
    public ModelAndView buyProduct(@RequestParam("productID") int theId) {
        ModelAndView modelAndView = new ModelAndView();

        Product product = productService.findById(theId);

        System.out.println(product.getInv());
        if (product != null && product.getInv() > 0) {
            // Decrement the product inventory by 1
            product.setInv(product.getInv() - 1);
            productService.save(product);

            modelAndView.addObject("message", "You bought a " + product.getName() + " successfully!");
        }
        else {
            modelAndView.addObject("message", "The " + product.getName() + " is out of stock!");
        }
        modelAndView.setViewName("buyproduct");
        return modelAndView;


    }
}
