package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;

public interface TaxValidator{
    public float getPetcentage(Dish d);
}
