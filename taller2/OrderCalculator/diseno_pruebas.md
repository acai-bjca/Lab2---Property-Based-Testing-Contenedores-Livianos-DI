**

# Diseño de Pruebas

### Inyector ---> BasicBillCalculator
```java
public class CalculatorModule extends AbstractModule{  
	@Override  
	protected void configure() {  
		bind(BillCalculator.class).to(BasicBillCalculator.class);  
		//bind(BillCalculator.class).to(TipBillCalculator.class);  
		//bind(BillCalculator.class).to(TaxBillCalculator.class);  
		  
        bind(TaxValidator.class).to(StandardTaxValidator.class);     
        //bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
	}  
}
```
La salida al ejecutar el programa es:
	21400  
	27500
___
### Inyector ---> TipBillCalculator
```java
public class CalculatorModule extends AbstractModule{  
	@Override  
	protected void configure() {  
		//bind(BillCalculator.class).to(BasicBillCalculator.class);  
		bind(BillCalculator.class).to(TipBillCalculator.class);  
		//bind(BillCalculator.class).to(TaxBillCalculator.class);  
		  
        bind(TaxValidator.class).to(StandardTaxValidator.class);     
        //bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
	}  
}
```
La salida al ejecutar el programa es:
	23540
	30250
	___
### TaxBillCalculator
#### Inyector ---> StandardTaxValidator
```java
public class CalculatorModule extends AbstractModule{
    @Override 
    protected void configure() {
        //bind(BillCalculator.class).to(BasicBillCalculator.class);
        //bind(BillCalculator.class).to(TipBillCalculator.class);
        bind(BillCalculator.class).to(TaxBillCalculator.class);

        bind(TaxValidator.class).to(StandardTaxValidator.class);     
        //bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);            
    }
}
```
La salida al ejecutar el programa es:
	23818
	30608
#### Inyector ---> SpecialRegimeTaxValidator
```java
public class CalculatorModule extends AbstractModule{
    @Override 
    protected void configure() {
        //bind(BillCalculator.class).to(BasicBillCalculator.class);
        //bind(BillCalculator.class).to(TipBillCalculator.class);
        bind(BillCalculator.class).to(TaxBillCalculator.class);

        //bind(TaxValidator.class).to(StandardTaxValidator.class);     
        bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);            
    }
}
```
La salida al ejecutar el programa es:
	23820
	30614
