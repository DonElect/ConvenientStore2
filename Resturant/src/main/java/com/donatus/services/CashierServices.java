package com.donatus.services;

import com.donatus.implementation.Customer;

public interface CashierServices {
    boolean addToStock(String item, int price);
    void dispenseReceipt(Customer customer);
}
