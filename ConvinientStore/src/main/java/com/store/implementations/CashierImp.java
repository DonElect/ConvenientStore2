package com.store.implementations;

import com.store.models.Cashier;
import com.store.services.CashierServices;

import java.util.Map;

public class CashierImp implements CashierServices {

    public Cashier cashier;

    public CashierImp(Cashier cashier){
        this.cashier = cashier;

    }

    public CashierImp(){

    }


    @Override
    public void sell() {
        if(cashier.isHired()) {
            System.out.println("The following item in your store are been bought.");
        }else System.out.println("You are no longer a staff here. And cannot sell");
    }

    @Override
    public boolean dispenseReceipt() {
        if(cashier.isHired()) {
            int sum = 0;
            System.out.println("****************************************************************");
            System.out.println("Purchase receipt");
            System.out.println("Products                  Price(₦\u200E)              Quantity");
            for (Map.Entry<String, Integer> items : new Customer().getCart().entrySet()) {
                System.out.println(items.getKey() + "         :             " + items.getValue() + "        :         " + new Customer().getCartQuantity().get(items.getKey()));
                sum += items.getValue() * (new Customer().getCartQuantity().get(items.getKey()));
            }
            System.out.println("Total price: " + sum + "\nThank you for patronizing us, have a great day!");
            System.out.println();
            //If receipt was successfully dispensed
            return true;
        }
        else {
            System.out.println("You are no longer a staff here. And so cannot dispense receipt");
            return false;
        }
    }

    @Override
    public boolean addProduct(String item, int price, int quantity) {
        if(cashier.isHired()) {
            new Products().getProducts().put(item, price);
            new Products().getProductQuantity().put(item, quantity);
            System.out.println(item + " has been added to the store.");
            System.out.println();
            // If products were successfully added
            return true;
        }
        else {
            System.out.println("You are no longer a staff here. And so cannot add products to store");
            return false;
        }
    }

}
