package edu.eci.pdsw.orderCalculator.calculator.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.AbstractModule;
import edu.eci.pdsw.orderCalculator.calculator.*;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;
/*1.
Definiendo una configuración inicial que permite asociar a las abstracciones las clases asociadas
*/
public class CalculatorModule extends AbstractModule{
    @Override 
    protected void configure() {
        //bind(BillCalculator.class).to(BasicBillCalculator.class);
        bind(BillCalculator.class).to(TipBillCalculator.class);
        //bind(BillCalculator.class).to(TaxBillCalculator.class);

        //bind(TaxValidator.class).to(StandardTaxValidator.class);     
        //bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
        //bind(OrdersManager.class);            
    }
}

