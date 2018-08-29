package main.java.edu.eci.pdsw.orderCalculator.services;

import java.util.LinkedList;
import java.util.List;

import main.java.edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import main.java.edu.eci.pdsw.orderCalculator.model.Order;
import main.java.edu.eci.pdsw.orderCalculator.model.OrderCalculatorException;

public class OrdersManager {
    BillCalculator cal;

    //BasicBillCalculator cal = new BasicBillCalculator();
    List<Order> orders;

    public OrdersManager() {
        orders = new LinkedList<>();
    }

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public Order findOrder(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return orders.get(n);
    }

    public int calculateOrderTotal(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return cal.calculatePrice(orders.get(n));
    }
}
