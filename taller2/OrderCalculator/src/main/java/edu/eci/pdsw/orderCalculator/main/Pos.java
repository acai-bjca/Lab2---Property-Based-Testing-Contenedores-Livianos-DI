package edu.eci.pdsw.orderCalculator.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.LinkedList;
import java.util.List;

import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.CalculatorModule;
import edu.eci.pdsw.orderCalculator.calculator.impl.TaxValidator;
import edu.eci.pdsw.orderCalculator.model.*;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;

public class Pos {
    public static void main(String a[]) throws OrderCalculatorException {    
        /*
        Para utilizar una configuración específica se asocia en el main.
        Se utiliza el injector para obtener una clase de una instancia asociada.
        */
        Injector injector = Guice.createInjector(new CalculatorModule());
        OrdersManager manager = injector.getInstance(OrdersManager.class);          	        
        loadOrders(manager);  
        
        System.out.println(manager.calculateOrderTotal(0));
        System.out.println(manager.calculateOrderTotal(1));
    }

    private static void loadOrders(OrdersManager manager) {
        Order o = new Order();
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.DRINK, "pepsi 300ml", 3900, 80));
        o.addDish(new Dish(DishType.PLATE, "hamburguesa", 8000, 295));
        o.addDish(new Dish(DishType.DRINK, "sprite 300ml", 2000, 2000));

        manager.placeOrder(o);

        o = new Order();

        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        o.addDish(new Dish(DishType.DRINK, "pepsi litro", 5000, 2000));

        manager.placeOrder(o);
    }
}
