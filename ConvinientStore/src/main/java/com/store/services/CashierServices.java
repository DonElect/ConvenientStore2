package com.store.services;

public interface CashierServices {
    void sell();
    boolean dispenseReceipt();
    boolean addProduct(String item, int price, int quantity);
}
