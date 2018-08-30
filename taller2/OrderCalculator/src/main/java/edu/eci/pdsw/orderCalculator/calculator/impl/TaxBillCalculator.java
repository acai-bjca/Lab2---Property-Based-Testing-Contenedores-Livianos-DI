package edu.eci.pdsw.orderCalculator.calculator.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.Order;


public class TaxBillCalculator implements BillCalculator{
	private final TaxValidator taxValidator;
	
        @Inject
	public TaxBillCalculator(TaxValidator taxValidator ) {
            this.taxValidator = taxValidator;
	}

	public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            float ivaDish = (p.getPrice()*taxValidator.getPetcentage(p))/100;
            total += p.getPrice()+ivaDish;
        }
        if(total>15000) {
        	int servicio = (total*10)/100;
        	total += servicio;        	
        }
        return total;
    }
}
