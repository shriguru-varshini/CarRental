package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	Calculator calc = new Calculator();
	@Test //->Annotation
	void testAdd() {
		Calculator calc=new Calculator();
		calc.add(5, 10); //functionality
        //assertions->match in expected result,actual result
        //assertEquals
         assertEquals(15,calc.add(5, 10)); //test case for add method
	}
		

	@Test
	void testSub() {
		Calculator calc=new Calculator();
		assertEquals(-5,calc.sub(5, 10));
	}
	
	//assertTrue(Condition) ->verify condition - true
	//assertFalse(Condition) ->verify condition - false
	
	@Test
	void testConditionTrue() {
		Calculator calc=new Calculator();
		assertTrue(calc.add(2,9)>0); // if result = +ve
	}
	
	@Test
	void testConditionFalse() {
		Calculator calc=new Calculator();
		assertFalse(calc.sub(9,8)<0); // if result =+ve 
	}
	@Disabled("Temp Disable")
	@Test
	void testNull() {
		Calculator calc=new Calculator();
		assertNull(calc.add(null,null)); //validate null case
	}
	
	@Disabled("Temp Disable")
	@Test
	void testNotNull() {
		Calculator calc=new Calculator();
		assertNotNull(calc.add(2,8)); //validate not null result
	}

	@ParameterizedTest //same test , diff set of data
	@ValueSource(ints = {12,15,16,17})
	void testAddParam(int number) { // arug -> from valuesource
		Calculator calc = new Calculator();
		assertEquals(number+10,calc.add(number,10));
	}
	//6 test+ 4 value in param times = 10 cases
	
	@ParameterizedTest //same test , diff set of data
	@CsvSource ({
		"5, 7, 12",
		"3, 6, 9",
		"7, 5, 12",
		"8, 9, 17"
	})
	//a b expected
	void testAddParamCsv(int a, int b,int expected) { // arug -> from valuesource
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(a,b));
		//runs for 4 sets
	}	
	
	//timesouts for test
	//few tests ->too lond to run -> infinite loop , performance issue 
	//assertTimeout , Junit 4 ->timeout param
	
	@Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(1000),() -> {
			
			//simulate
			Thread.sleep(200);
			calc.add(2,3);	
		});
	}
	
	//disable the test junit 4 ->@Ignore
	//junit 5 ->@Disabled - notnull & null
	
	//testing exception
	//pass ->exception is thrown
	@Test
	void testException() {
		
		//add div method
		ArithmeticException exception = assertThrows(ArithmeticException.class,()->{
			calc.div(12,5);
		});
	}
}
