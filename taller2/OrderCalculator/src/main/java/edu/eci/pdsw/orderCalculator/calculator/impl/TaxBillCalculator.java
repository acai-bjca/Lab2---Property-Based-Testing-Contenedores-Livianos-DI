package main.java.edu.eci.pdsw.orderCalculator.calculator.impl;

import main.java.edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import main.java.edu.eci.pdsw.orderCalculator.model.Dish;
import main.java.edu.eci.pdsw.orderCalculator.model.Order;
import javax.inject;

public class TaxBillCalculator implements BillCalculator{
	private final StandardTaxValidator standardTaxV;
	private final SpecialRegimeTaxValidator specialRegimeTaxV;
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new TaxBillCalculatorModule());
		BillCalculator billCalculator = injector.getInstance(BillCalculator.class);
	}
	
	@Inject 
	public TaxBillCalculator(StandardTaxValidator standardTaxV, SpecialRegimeTaxValidator specialRegimeTaxV) {
		this.standardTaxV = standardTaxV;
	    this.specialRegimeTaxV = specialRegimeTaxV;
	}

	public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            int ivaDish = (p.getPrice()*19)/100;
            total += p.getPrice()+ivaDish;
        }
        if(total>15000) {
        	int servicio = (total*10)/100;
        	total += servicio;        	
        }
        return total;
    }
}
