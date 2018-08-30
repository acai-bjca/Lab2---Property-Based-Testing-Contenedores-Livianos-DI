package edu.eci.pdsw.orderCalculator.calculator.impl;

import com.google.inject.AbstractModule;
import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;

public class TaxBillCalculatorModule extends AbstractModule{
	@Override 
	protected void configure() {
            bind(TaxValidator.class).to(StandardTaxValidator.class);       
            bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
            bind(BillCalculator.class).to(TaxBillCalculator.class);
	}
}