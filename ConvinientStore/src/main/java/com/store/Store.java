package com.store;

import com.store.implementations.CashierImp;
import com.store.implementations.Customer;
import com.store.implementations.ManagerImp;
import com.store.models.Cashier;
import com.store.models.Manager;


public class Store {

    public static void main(String[] args) {
        //Creating the manager and customer instances and hiring two new cashiers
        Manager manager = new Manager("Donatus", "Okpala", 29,
                "D55B78", "donatus.okpala@decagon.dev", "Decagon Institute, Ohen");
        ManagerImp managerImp = new ManagerImp(manager);

       Cashier cashier1 = new Cashier("Stella", "Louis",
                25, "D0001B2", "stellalouis@gmail.com", "Ikorrodu, Lagos", "Stand 1");
        Cashier cashier2 = new Cashier("Marry", "John",
                25, "D0002B2", "maryjohn@gmail.com", "Makurdi, Benue", "Stand 2");
        CashierImp cashierImp1 = new CashierImp(cashier1);
        CashierImp cashierImp2 = new CashierImp(cashier2);

        managerImp.hire(cashier1);
        managerImp.hire(cashier2);
        //manager.fire(cashier2);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // Add items to store
        cashierImp1.addProduct("Mango", 100, 50);
        cashierImp1.addProduct("Orange", 50, 30);
        cashierImp1.addProduct("Banana", 500, 35);
        cashierImp1.addProduct("WaterMelon", 800, 55);
        cashierImp1.addProduct("Garri", 200, 65);

        // Customer1 Buying items from store
        customer1.addToCart("Mango", 2);
        customer1.addToCart("Orange", 5);
        customer1.addToCart("Banana", 2);
        customer1.addToCart("Garri", 3);

        customer1.removeFromCart("Mango", 1);
        customer1.removeFromCart("Garri", 2);

        // Customer2 buying items
        customer2.addToCart("Mango", 22);
        customer2.addToCart("Orange", 15);
        customer2.addToCart("Banana", 20);
        customer2.addToCart("Garri", 31);


        customer1.buy();
        customer2.buy();

        cashierImp2.sell(customer1);
        cashierImp2.dispenseReceipt(customer1);

        cashierImp2.sell(customer2);
        cashierImp2.dispenseReceipt(customer2);
    }
}
