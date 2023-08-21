package com.store.services;

import com.store.implementations.CashierImp;
import com.store.models.Cashier;

public interface ManagerInterface {
    boolean hire(Cashier cashier);
    boolean fire(Cashier cashier);
}
