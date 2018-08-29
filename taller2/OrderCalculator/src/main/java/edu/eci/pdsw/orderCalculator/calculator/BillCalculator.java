package main.java.edu.eci.pdsw.orderCalculator.calculator;

import main.java.edu.eci.pdsw.orderCalculator.model.Order;

public interface BillCalculator {
    public int calculatePrice(Order o);
}
