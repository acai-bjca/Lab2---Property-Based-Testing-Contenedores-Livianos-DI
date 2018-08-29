package edu.eci.pdsw.orderCalculator;

import edu.eci.pdsw.orderCalculator.model.*;
import edu.eci.pdsw.orderCalculator.model.Dish;
import java.util.List;
import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.*;


public class OrderGenerator {
    public static Gen<Order> order() {        
        return dishes().map((dishesList) -> {
            Order order = new Order();
            for (Dish dish : dishesList) {
                order.addDish(dish);
            }
            return order;
        });
    }
    
    private static Gen<List<Dish>> dishes() {
        return lists().of(DishGenerator.dishes()).ofSizes(integers().allPositive().map((x) -> (x-1))); 
    }
}
//