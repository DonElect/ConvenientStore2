package com.donatus.implementation;

import com.donatus.models.Cashier;
import com.donatus.models.Products;
import com.donatus.services.CashierServices;

import java.util.Map;

public class CashierImp implements CashierServices {
    //private Products products;
    //private Customer customer;

    private Cashier cashier;

    public CashierImp(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierImp(){

    }

    @Override
    public boolean addToStock(String item, int price) {
        if (!new Products().getProductList().containsKey(item)) {
            new Products().getProductList().put(item, price);
            return true;
        }
        else {
            System.out.println(item + " already in stock.");
            return false;
        }
    }

    @Override
    public void dispenseReceipt(Customer customer) {
        int sum = 0;
        System.out.println("---------------------------------");
        System.out.println("Items"+"                      "+"Price");
        for(Map.Entry<String, Integer> items : customer.getCart().entrySet()){
            System.out.println(items.getKey()+"                     "+items.getValue());
            sum += items.getValue();
        }
        System.out.println("Bill: "+sum);
        System.out.println("Thank you for patronizing us. Have a nice day");
    }
}
