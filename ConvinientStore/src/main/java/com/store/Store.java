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

        Customer customer = new Customer();

        cashierImp1.addProduct("Mango", 100, 10);
        cashierImp1.addProduct("Orange", 50, 20);
        cashierImp1.addProduct("Banana", 500, 5);
        cashierImp1.addProduct("WaterMelon", 800, 15);
        cashierImp1.addProduct("Garri", 200, 5);

        customer.addToCart("Mango", 2);
        customer.addToCart("Orange", 5);
        customer.addToCart("Banana", 2);
        customer.addToCart("Garri", 3);

        customer.removeFromCart("Mango", 1);
        customer.removeFromCart("Garri", 2);


        customer.buy();

        cashierImp2.sell();
        cashierImp2.dispenseReceipt();
    }
}
