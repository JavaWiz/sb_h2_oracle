package com.javawiz.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawiz.entity.Product;
import com.javawiz.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    private List<Product> getAllPersons() {
        return productService.listAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getPerson(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/products")
    private int savePerson(@RequestBody Product product) {
        productService.saveProduct(product);
        return product.getId();
    }
}