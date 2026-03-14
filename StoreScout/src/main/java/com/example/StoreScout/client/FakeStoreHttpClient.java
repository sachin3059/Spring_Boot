package com.example.StoreScout.client;


import com.example.StoreScout.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("https://fakestoreapi.com")
public interface FakeStoreHttpClient {

    @GetExchange("/products")
    List<Product> getAllProducts();

    @GetExchange("/products/{id}")
    Product getProduct(@PathVariable int id);

    @GetExchange("/products/categories")
    List<String> getCategories();

    @GetExchange("/products/category/{category}")
    List<Product> getByCategory(@PathVariable String category);
}
