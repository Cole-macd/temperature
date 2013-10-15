/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {
	private final double PRECISION = 0.00001;
	@Test
	public void testGetValue() {
		//test boundary condition, negative input, precision, and double casting inputs
		
		//boundary test for negative Kelvin since negative Kelvin is not allowed
		Temperature testBoundary = new Temperature(0.0, Temperature.Units.KELVIN);
		assertEquals("Should equal 0.0", 0.0, testBoundary.getValue(), PRECISION);
		
		//check for precision of output
		Temperature precisionTest = new Temperature(0.1111111, Temperature.Units.CELSIUS);
		assertEquals("Should equal 0.11111", 0.11111, precisionTest.getValue(), PRECISION);
		
		//check for cast to double
		Temperature doubleCasting = new Temperature(10, Temperature.Units.FAHRENHEIT);
		assertEquals("Should equal 10.0", 10.0, doubleCasting.getValue(), PRECISION);
		
		//check negative input
		Temperature negativeInput = new Temperature(-20, Temperature.Units.CELSIUS);
		assertEquals("Should equal -20.0", -20.0, negativeInput.getValue(), PRECISION);
	}
	
	@Test
	public void testGetUnits() {
		//test 3 possible change unit cases
		
		//test Kelvin input
		Temperature kelvinTest = new Temperature(20, Temperature.Units.KELVIN);
		assertEquals("Should be Kelvin", Temperature.Units.KELVIN, kelvinTest.getUnits());
		
		//test Celsius input
		Temperature celsiusTest = new Temperature(0, Temperature.Units.CELSIUS);
		assertEquals("Should be Celsius", Temperature.Units.CELSIUS, celsiusTest.getUnits());
		
		//test Fahrenheit input
		Temperature fahrenheitTest = new Temperature(-20, Temperature.Units.FAHRENHEIT);
		assertEquals("Should be Fahrenheit", Temperature.Units.FAHRENHEIT, fahrenheitTest.getUnits());
	}

}