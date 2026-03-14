package com.example.StoreScout.service;

import com.example.StoreScout.client.FakeStoreHttpClient;
import com.example.StoreScout.model.Product;
import org.springframework.stereotype.Service;

@Service
public class StoreScoutService {

    private final FakeStoreHttpClient client;

    public StoreScoutService(FakeStoreHttpClient client) {
        this.client = client;
    }

    public void listProducts() {
        client.getAllProducts().forEach(this::print);
    }

    public void viewProduct(int id) {
        print(client.getProduct(id));
    }

    public void categories(){
        client.getCategories().forEach(System.out::println);
    }
    public void byCategory(String category){
        client.getByCategory(category).forEach(this::print);
    }

    private void print(Product p){
        System.out.println("────────────────────────────");
        System.out.println("ID: " + p.getId());
        System.out.println("Title: " + p.getTitle());
        System.out.println("Price: ₹" + p.getPrice());
        System.out.println("Category: " + p.getCategory());
        System.out.println("────────────────────────────");
    }


}
