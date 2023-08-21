package com.store.implementations;

import com.store.models.Cashier;
import com.store.models.Manager;
import com.store.services.ManagerInterface;

import java.util.ArrayList;
import java.util.List;

public class ManagerImp implements ManagerInterface {
    private static List<Cashier> cashierList = new ArrayList<>();
    public Manager manager;
    public ManagerImp(Manager manager) {
        this.manager = manager;
    }

    public ManagerImp(){

    }

    @Override
    public boolean hire(Cashier cashier) {
        if (!cashier.isHired()) {
            cashier.setHired(true);
            cashierList.add(cashier);
            System.out.println("New cashier employed.");
            return true;
        }
        else {
            System.out.println("This cashier is already hired");
            return false;
        }
    }

    @Override
    public boolean fire(Cashier cashier) {
        if(cashierList.contains(cashier)){
            cashier.setHired(false);
            cashierList.remove(cashier);
            System.out.println("Welcome to Roban Store Miss "+cashier.getFirstName()+ ". \nMy name is "+manager.getFirstName()+" i am the manager.");
            return true;
        }
        else {
            System.out.println("No Cashier with such name.");
            return false;
        }
    }
    public List<Cashier> getCashierList() {
        return cashierList;
    }

//    public void addToCashierList(Cashier cashier) {
//        cashierList.add(cashier);
//    }
}
