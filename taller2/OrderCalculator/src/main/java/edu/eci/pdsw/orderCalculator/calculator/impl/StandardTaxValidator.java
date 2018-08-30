package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;
import javax.inject.Singleton;

public class StandardTaxValidator implements TaxValidator{
    @Singleton
    public float getPetcentage(Dish d) {
        return 0.19f;      
    }
}