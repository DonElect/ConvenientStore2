package com.store.implementations;

import com.store.models.Cashier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    // Creating the necessary instances
    ManagerImp manager = new ManagerImp();
    Cashier cashier = new Cashier("Jane", "Mary",
            25, "D0002B02", "jamemary@gmail.com",
            "Ohen", "Stand 1");
    CashierImp cashierImp = new CashierImp(cashier);
    Customer customer1 = new Customer();
    Customer customer2 = new Customer();

    @Test
    void addToCart() {
        manager.hire(cashier);

        cashierImp.addProduct("Mango", 100, 5);
        cashierImp.addProduct("Orange", 50, 50);
        cashierImp.addProduct("Apple", 300, 15);

        assertSame("done", customer1.addToCart("Mango", 3));

        // Total amount of Mango=5. Customer1 already added 5 to his cart. So if customer2 tries to take more than the
        // remain, it won't work.
        assertSame("not done", customer2.addToCart("Mango", 3));

        // Total amount of Orange=50, and customer2 collected all. If customer1 tries to collect some, it would out-of-stock
        customer2.addToCart("Orange", 50);
        assertSame("out-of-stock", customer1.addToCart("Orange", 3));
    }

    @Test
    void removeFromCart() {
        manager.hire(cashier);

        cashierImp.addProduct("Mango", 100, 5);
        cashierImp.addProduct("Orange", 50, 50);
        cashierImp.addProduct("Apple", 300, 15);

        customer1.addToCart("Orange", 3);
        customer1.addToCart("Mango", 5);
        customer1.addToCart("Apple", 10);

        // Added 3 oranges to cart and removed all 3 oranges, should return "done"
        assertSame("done", customer1.removeFromCart("Orange", 3));

        // Trying to remove an item that is not in cart should return not-in-cart
        assertSame("not-in-cart", customer1.removeFromCart("PawPaw", 3));
    }

    @Test
    void buy() {
        manager.hire(cashier);

        cashierImp.addProduct("Mango", 100, 5);
        cashierImp.addProduct("Orange", 50, 50);
        cashierImp.addProduct("Apple", 300, 15);

        customer1.addToCart("Orange", 3);
        customer1.addToCart("Mango", 5);
        customer1.addToCart("Apple", 10);

        assertTrue(customer1.buy());
    }
}