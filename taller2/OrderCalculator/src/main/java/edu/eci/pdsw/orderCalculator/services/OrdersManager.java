package edu.eci.pdsw.orderCalculator.services;

import com.google.inject.Inject;
import java.util.LinkedList;
import java.util.List;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.model.OrderCalculatorException;

public class OrdersManager {
    private final BillCalculator cal;
    //BasicBillCalculator cal = new BasicBillCalculator();
    List<Order> orders;

    @Inject
    public OrdersManager(BillCalculator cal) {
        this.cal =cal;
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
