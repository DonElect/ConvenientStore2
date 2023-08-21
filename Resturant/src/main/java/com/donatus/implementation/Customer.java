package com.donatus.implementation;

import com.donatus.models.Products;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static Map<String, Integer> cart = new HashMap<>();
    public Customer(){

    }

    public void makeRequest(String item){
        if(new Products().getProductList().containsKey(item)){
            cart.put(item, new Products().getProductList().get(item));
            System.out.println(item+" request made.");
            System.out.println();
        }
        else {
            System.out.println("We dont sell " + item + " here'");
            System.out.println();
        }
    }

    public void buy(){
        //System.out.println(cart);
        System.out.println("-----------------------------------");
        System.out.println("Item"+"               "+"Price");
        for(Map.Entry<String, Integer> items : cart.entrySet()){
            System.out.println(items.getKey()+"        |        "+items.getValue());
        }
        System.out.println("Go to the cashier stand and pay");
        System.out.println();
    }

    public Map<String, Integer> getCart() {
        return cart;
    }
}
