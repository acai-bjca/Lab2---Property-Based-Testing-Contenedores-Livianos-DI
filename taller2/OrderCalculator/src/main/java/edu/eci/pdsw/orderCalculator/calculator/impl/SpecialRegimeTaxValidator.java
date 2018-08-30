package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;;
import javax.inject.Singleton;

public class SpecialRegimeTaxValidator implements TaxValidator{
	@Singleton
	public float getPetcentage(Dish d) {
		float iva;
		if(d.getType() == DishType.DRINK && d.getCalories() >1000) {				
			iva = 0.29f;
		}else {
			iva = 0.19f;			
		} 
		return iva;
    }
}
