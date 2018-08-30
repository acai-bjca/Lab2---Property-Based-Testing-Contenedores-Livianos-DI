package edu.eci.pdsw.orderCalculator;

import org.junit.Test;
import static org.quicktheories.QuickTheory.qt;
import edu.eci.pdsw.orderCalculator.calculator.impl.*;
import edu.eci.pdsw.orderCalculator.model.*;
import edu.eci.pdsw.PBTCalculator;

public class BasicBillCalculatorTest {

    @Test
    public void debeCalcularBienElTotalDeLAsOrdenes() {
    	PBTCalculator pbt = new PBTCalculator("debeCalcularBienElTotalDeLAsOrdenes");
        qt()
            .forAll(OrderGenerator.order())
            .check(order ->  {
                BasicBillCalculator calculator = new BasicBillCalculator();
                int total = calculator.calculatePrice(order);
                int totalParaComparar = 0;
                for (Dish d : order.getDishes()){
                    totalParaComparar += d.getPrice();
                }
                if (total < 0) {
                	pbt.collect("El total debe ser positivo. ");
                	return false;
                }
                else {
                	pbt.collect("Se calculó el total de la orden correctamente.");
                	return totalParaComparar == total;
                }
            });
        pbt.results();
    }
}
