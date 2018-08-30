package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;;
import javax.inject.Singleton;

public class SpecialRegimeTaxValidator implements TaxValidator{
    @Singleton
    public float getPetcentage(Dish d) {
        float iva;
        if(d.getType() == DishType.DRINK && d.getCalories() >1000) {				
                iva = 1.29f;
        }else {
                iva = 1.19f;			
        } 
        return iva;
    }
    
}
