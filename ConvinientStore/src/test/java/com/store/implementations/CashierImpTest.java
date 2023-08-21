package com.store.implementations;

import com.store.models.Cashier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierImpTest {
    ManagerImp manager;
    Cashier cashier1;
    CashierImp cashierImp1;
    Cashier cashier2;
    CashierImp cashierImp2;
    Customer customer;
    @BeforeEach
    public void runBeforeAnyOtherTest(){
        manager = new ManagerImp();
        cashier1 = new Cashier("Jane", "Mary",
                25, "D0002B02", "jamemary@gmail.com",
                "Ohen", "Stand 1");
        cashierImp1 = new CashierImp(cashier1);
        cashier2 = new Cashier("Mike", "John",
                26, "D0003B02", "mikejohn@gmail.com",
                "GRA", "Stand 2");
        cashierImp2 = new CashierImp(cashier2);
        customer = new Customer();
    }

    // A cashier has to be hired before they can add or dispense receipt to customers
    @Test
    public void dispenseReceipt() {
        manager.hire(cashier1);
        manager.hire(cashier2);

        cashierImp1.addProduct("Mango", 100, 5);
        cashierImp1.addProduct("Orange", 50, 50);
        cashierImp1.addProduct("Apple", 300, 15);

        customer.addToCart("Mango", 3);
        customer.addToCart("Orange", 15);
        customer.addToCart("Apple", 5);

        assertTrue(cashierImp2.dispenseReceipt(customer));

    }

    @Test
    void addProduct() {
        manager.hire(cashier1);
        assertTrue(cashierImp1.addProduct("PawPaw", 300, 15));
    }
}