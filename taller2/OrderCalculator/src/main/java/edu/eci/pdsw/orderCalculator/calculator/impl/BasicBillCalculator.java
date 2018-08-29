package main.java.edu.eci.pdsw.orderCalculator.calculator.impl;

import main.java.edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import main.java.edu.eci.pdsw.orderCalculator.model.Dish;
import main.java.edu.eci.pdsw.orderCalculator.model.Order;

public class BasicBillCalculator implements BillCalculator {

    public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            total += p.getPrice();
        }
        return total;
    }
}
