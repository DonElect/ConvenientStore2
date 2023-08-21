package com.donatus.models;

import java.util.HashMap;
import java.util.Map;

public class Products {
    private static Map<String, Integer> productList = new HashMap<>();

    public Products(){

    }
    public Map<String, Integer> getProductList() {
        return productList;
    }
}
