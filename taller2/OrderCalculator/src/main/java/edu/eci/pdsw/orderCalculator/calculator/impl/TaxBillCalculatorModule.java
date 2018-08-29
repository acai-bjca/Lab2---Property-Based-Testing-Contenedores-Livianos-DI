package main.java.edu.eci.pdsw.orderCalculator.calculator.impl;

import java.lang.Object;
import main.java.edu.eci.pdsw.orderCalculator.model.Dish;
import com.google.inject.AbstractModule;

public class TaxBillCalculatorModule extends AbstractModule{
	@Override 
	protected void configure() {
		bind(TaxBillCalculator.class).to(StandardTaxValidator.class);
		bind(TaxBillCalculator.class).to(SpecialRegimeTaxValidator.class);
		bind(BillCalculator.class).to(TaxBillCalculator.class);
	}
}