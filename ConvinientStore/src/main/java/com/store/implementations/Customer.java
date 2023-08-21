package com.store.implementations;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    public Customer(){

    }
    private static Map<String, Integer> cart = new HashMap<>();
    private static Map<String, Integer> cartQuantity = new HashMap<>();

    public Map<String, Integer> getCart() {
        return cart;
    }

    public Map<String, Integer> getCartQuantity() {
        return cartQuantity;
    }

    public String addToCart(String item, int quantity) {
        Map<String, Integer> products = new Products().getProducts();
        if((products.containsKey(item)) && (new Products().getProductQuantity().get(item) >0)) {
            if ((new Products().getProductQuantity().get(item)) - quantity >= 0) {
                cart.put(item, products.get(item));
                if (cartQuantity.containsKey(item)) {
                    cartQuantity.replace(item, cartQuantity.get(item), cartQuantity.get(item) + quantity);
                } else cartQuantity.put(item, quantity);

                new Products().getProductQuantity().replace(item, new Products().getProductQuantity().get(item),
                        new Products().getProductQuantity().get(item) - quantity);
                System.out.println(quantity+" "+item + "s added to your cart!  ");
                System.out.println();
                return "done";
            }
            return "not done";
        }
        else
            System.out.println("We dont have "+item.toUpperCase()+" in our store for now. or We are out of stock.");
        return "out-of-stock";
    }

    public String removeFromCart(String item, int quantity) {
        if(cart.containsKey(item)){
            if(cartQuantity.get(item)-quantity >= 0) {
                cartQuantity.replace(item, cartQuantity.get(item), cartQuantity.get(item) - quantity);
                new Products().getProductQuantity().replace(item, new Products().getProductQuantity().get(item),
                        new Products().getProductQuantity().get(item) + quantity);
                System.out.println(quantity + " " + item + " removed to your cart!");
                System.out.println();
            }else{
                cart.remove(item);
            }
            return "done";
        }
        else {
            System.out.println("You dont have " + item.toUpperCase() + " in our cart.");
            return "not-in-cart";
        }
    }


    public boolean buy(){
        int sum = 0;
        System.out.println("You about to pay for the following items in your list");
        System.out.println("********************************************");
        System.out.println("Products                  Price(₦\u200E)              Quantity");
        for(Map.Entry<String, Integer> item : cart.entrySet()){
            System.out.println(item.getKey()+"         :             "+item.getValue()+"        :        "+cartQuantity.get(item.getKey()));
            sum += item.getValue() * cartQuantity.get(item.getKey());
        }
        System.out.println("Total price: "+sum);
        System.out.println("Go over the counter and make payment. Cash or card payment is acceptable");
        System.out.println();
        return true;
    }
}
