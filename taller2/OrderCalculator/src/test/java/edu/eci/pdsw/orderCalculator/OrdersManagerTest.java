package edu.eci.pdsw.orderCalculator;

import org.junit.Test;
import static org.quicktheories.QuickTheory.qt;

public class OrdersManagerTest{
    @Test
    public void validarOrden() {
        qt()
        .forAll(OrderGenerator.order())
        .check(order ->  {
            if (order.getDishes().isEmpty()) {
                return false;
            }
            else{
                return true;
            }         
        });
    }
}
