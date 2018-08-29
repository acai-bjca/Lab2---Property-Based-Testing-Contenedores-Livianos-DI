package edu.eci.pdsw.orderCalculator;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;


/**
 *
 * @author estudiante
 */
public class DishGenerator {
    public static Gen<Dish> dishes() {        
        return dishType().zip(name(), price(), calories(), (type, name, price, calories) -> new Dish(type, name, price, calories));
    }
    
    private static Gen<DishType> dishType() {
        Class e;
        e = DishType.class;
        return Generate.enumValues(e); 
    }
    
    private static Gen<String> name() {
        //return strings().betweenCodePoints(97, 122).ofFixedNumberOfCodePoints(0);      
        return strings().basicLatinAlphabet().ofLengthBetween(3, 20); // TODO: Create person generator with random data. See QuickTheory - Cylinder example
    }
    
    private static Gen<Integer> price() {             
        return integers().from(5000).upTo(100000);
    }
    
    private static Gen<Integer> calories() {             
        return integers().from(0).upTo(10000);
    }
}
