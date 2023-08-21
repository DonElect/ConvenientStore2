package com.store.implementations;

import java.util.HashMap;
import java.util.Map;


public class Products {

    public Products(){

    }

    private static Map<String, Integer> products = new HashMap<>();
    private static Map<String, Integer> productQuantity = new HashMap<>();

    public Map<String, Integer> getProducts() {
        return products;
    }

    public Map<String, Integer> getProductQuantity() {
        return productQuantity;
    }
}
