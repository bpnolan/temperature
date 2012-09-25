package package5;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

import package5.Temperature.Units;

public class TemperatureTest {

	@Test
	public void testGetValue() {
		System.out.println("test if get value returns correct value");
		Temperature temperature = new Temperature(20, Units.CELCIUS);
		assertTrue(temperature.getValue()==20);
		
	}

	@Test
	public void testGetUnits_Celcius() {
		System.out.println("test if Celcius units return Celcius");
		Temperature temperature = new Temperature(20, Units.CELCIUS);
		assertTrue(temperature.getUnits()==Units.CELCIUS);
		
	}
	
	
	@Test
	public void testGetUnits_Fahrenheit() {
		System.out.println("test if FAHRENHEIT units return FAHRENHEIT");
		Temperature temperature = new Temperature(-20, Units.FAHRENHEIT);
		assertTrue(temperature.getUnits()==Units.FAHRENHEIT);
		
	}
	
	@Test
	public void testGetUnits_Kelvin() {
		System.out.println("test if KELVIN units return KELVIN");
		Temperature temperature = new Temperature(20, Units.KELVIN);
		assertTrue(temperature.getUnits()==Units.KELVIN);
	
	}
	
	
	

	/*	For testing ChangeUnits, we will test all 6 combinations of the method.
	 *  The numbers we choose will test the boundary conditions, as well as all the math
	 *  (for example we don't want to test 0C and 32F, because that wont test the 5/9 term)
	 *  We will also choose numbers that test both positive and negative temperatures, except
	 *  for negative Kelvin temperatures.
	 */ 
	@Test
	public void testChangeUnits_CelciustoKelvin() {
		System.out.println("Tests the Celcius to Kelvin Conversion");
		Temperature t1 = new Temperature(0, Units.CELCIUS);
		Temperature t2 = new Temperature(273.15, Units.KELVIN);
		t1.changeUnits(Units.KELVIN);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}
	
	
	@Test
	public void testChangeUnits_CelciustoFahrenheit() {
		System.out.println("Tests the Celcius to Fahrenheit Conversion");
		Temperature t1 = new Temperature(40, Units.CELCIUS);
		Temperature t2 = new Temperature(104, Units.FAHRENHEIT);
		t1.changeUnits(Units.FAHRENHEIT);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}
	
	
	@Test
	public void testChangeUnits_FahrenheittoCelcius() {
		System.out.println("Tests the Fahrenheit to Celcius Conversion");
		Temperature t1 = new Temperature(50, Units.FAHRENHEIT);
		Temperature t2 = new Temperature(10, Units.CELCIUS);
		t1.changeUnits(Units.CELCIUS);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}
	
	
	@Test
	public void testChangeUnits_FahrenheittoKelvin() {
		System.out.println("Tests the Fahrenheit to Kelvin Conversion");
		Temperature t1 = new Temperature(68, Units.FAHRENHEIT);
		Temperature t2 = new Temperature(293.15, Units.KELVIN);
		t1.changeUnits(Units.KELVIN);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}
	
	
	@Test
	public void testChangeUnits_KelvintoCelcius() {
		System.out.println("Tests the Kelvin to Celcius Conversion");
		Temperature t1 = new Temperature(283.65, Units.KELVIN);
		Temperature t2 = new Temperature(10.5, Units.CELCIUS);
		t1.changeUnits(Units.CELCIUS);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}
	
	
	@Test
	public void testChangeUnits_KelvintoFahrenheit() {
		System.out.println("Tests the Kelvin to Fahrenheit Conversion");
		Temperature t1 = new Temperature(283.15, Units.KELVIN);
		Temperature t2 = new Temperature(50, Units.FAHRENHEIT);
		t1.changeUnits(Units.FAHRENHEIT);
		assertTrue(t1.getValue()==t2.getValue());
     	
	}

	
	/* Use one test for each true/false case of the 3 possible comparisons.	 * 
	 * We will choose numbers that test the boundary and precision of the equals method	 * 
	 */
	@Test
	public void testEqualsObject_CelciusFahrenheit() {
		System.out.println("Tests the Equals for 2 equal temps (One in C and one in F)");
		
		Temperature t1 = new Temperature(0, Units.CELCIUS);
		Temperature t2 = new Temperature(32, Units.FAHRENHEIT);
		
		assertTrue(t1.equals(t2));		
		
	}
	
	
	@Test
	public void testNOTequalsObject_CelciusFahrenheit() {
		System.out.println("Tests the Equals for 2 unequal temps (One in C and one in F)");
		
		Temperature t1 = new Temperature(0, Units.CELCIUS);
		Temperature t2 = new Temperature(31.5, Units.FAHRENHEIT);
		
		assertTrue(!t1.equals(t2));		
		
	}
	
	
	@Test
	public void testequalsObject_CelciusKelvin() {
		System.out.println("Tests the Equals for 2 equal temps (One in C and one in K)");
		
		Temperature t1 = new Temperature(5, Units.CELCIUS);
		Temperature t2 = new Temperature(278.15, Units.KELVIN);
		
		assertTrue(t1.equals(t2));		
		
	}
	
	
	@Test
	public void testNOTequalsObject_CelciusKelvin() {
		System.out.println("Tests the Equals for 2 unequal temps (One in C and one in K)");
		
		Temperature t1 = new Temperature(5, Units.CELCIUS);
		Temperature t2 = new Temperature(278.0, Units.KELVIN);
		
		assertTrue(!t1.equals(t2));		
		
	}
	
	
	@Test
	public void testequalsObject_FahrenheitKelvin() {
		System.out.println("Tests the Equals for 2 equal temps (One in F and one in K)");
		
		Temperature t1 = new Temperature(32, Units.FAHRENHEIT);
		Temperature t2 = new Temperature(273.15, Units.KELVIN);
		
		assertTrue(t1.equals(t2));		
		
	}
	
	
	@Test
	public void testNOTequalsObject_FahrenheitKelvin() {
		System.out.println("Tests the Equals for 2 unequal temps (One in F and one in K)");
		
		Temperature t1 = new Temperature(-40, Units.FAHRENHEIT);
		Temperature t2 = new Temperature(273.15, Units.KELVIN);
		
		assertTrue(!t1.equals(t2));		
		
	}
	
	
	
	/* Finally, we will test to be sure the equals method does not change the value of the temperatures
	 * being compared.	 * 
	 */
	@Test
	public void testValueAfterEqualsMethod() {
		System.out.println("Tests that the value of a temperature is not changed by the equals method");
		
		Temperature t1 = new Temperature(-40, Units.FAHRENHEIT);
		Temperature t2 = new Temperature(273.15, Units.KELVIN);
		t1.equals(t2);
		
		assertTrue(t1.getValue()==-40);		
		
	}

}
