package Junit;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderService2Test {

	private OrderService2 orderservice2;
	
	@BeforeEach // intialize orderservice before test case
	public void setUp() {
		orderservice2 = new OrderService2();
	}
	
	//valid price cal test
	//price ->
	
	@Test
	public void TestCalPrice_validInputs() {
		double price = 100.00;
		int quantity = 2;
		double expectedPrice = price*quantity*(1-orderservice2.getDiscount());
		assertEquals(expectedPrice, orderservice2.calPrice(price, quantity));
	}
	
	@Test
	public void TestCalPrice_invalidquant() {
		double price = 100;
		int quantity = 0;
			assertEquals(0,orderservice2.calPrice(price,quantity));
	}
		
	@Test
		public void TestCalPrice_invalidInputs() {
			
			IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, ()->{
				orderservice2.calPrice(-100.00, 2);
			});
		}

	@Test
	void TestSuccessfullyPlaced() {
		boolean result = orderservice2.placeOrder(5);
		assertTrue(result, "Order should be placed successfully");
		assertEquals(5, orderservice2.getStock(), "Stock should be reduced by the ordered quantity");
	}
	
	//edge case -> quantity exactly same as stock
	 @Test
		 void TestPlaceOrderExactStock() {
		        boolean result = orderservice2.placeOrder(10);
		        assertTrue(result, "Order should be placed successfully");
		        assertEquals(0, orderservice2.getStock(), "Stock should be 0 after ordering the exact stock amount");
		    }
	 
	 
		//edge case -> order just below stock limit i.e. 10
	 @Test
		 void TestPlaceOrderBelowStockLimit() {
		        boolean result = orderservice2.placeOrder(9);
		        assertTrue(result, "Order should be placed successfully");
		        assertEquals(1, orderservice2.getStock(), "Stock should be reduced to 1 after ordering 9 out of 10");
		    }
	 
	// Exceptional Cases
		
		// place order beyond stock
		// set stock -> -ve stock
		// set discount -> (0-1), 1.5 ->
		// negative price
		// negative quantity
	 
	 @Test
	 void TestPlaceOrderbeyoundStock() {
		 
		    int stock = 15;
		    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.placeOrder(stock);
	        });
	    }
	 
	 @Test
	 void TestNegativestock() {
		 int stock = -5;
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.setStock(stock);
	        });
	 }
	 
	 @Test
	 void Testinvaliddiscount() {
		 double discount = 1.5;
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.setDiscount(discount);
	        });
	 }
	 
	 @Test
	 void TestNegativeprice() {
		 int quantity = 4;
		 double price = -50;
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.calPrice(price,quantity);
	        });
	 }
	 
	 @Test
	 void TestNegativequantity() {
		 int quantity = -4;
		 double price = 50;
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.calPrice(price,quantity);
	        });
	 }
	 
	 //parameterized test
	 
	 @ParameterizedTest //same test , diff set of data
	 @ValueSource(ints = {1,4,7,10})
		void testdiffquant(int number) { 
		 assertTrue(orderservice2.placeOrder(number));
		}
	 
	 @ParameterizedTest //same test , diff set of data
	 @ValueSource(ints = {11,13,15})
	 void testboundcondition(int number) { 
		 
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.placeOrder(number);
	        });
		}
	 
	 @ParameterizedTest //same test , diff set of data
	 @ValueSource(doubles = {-0.5,1.5,2.0})
	 void testdiscountcondition(double number) { 
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.setDiscount(number);
	        });
	 }
	 
	 @ParameterizedTest //same test , diff set of data
	 @ValueSource(ints = {-5,-10,-15})
	 void teststockcondition(int number) {
		 IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	            orderservice2.placeOrder(number);
	        });
	 }
	 @ParameterizedTest
	 @CsvSource({
		    "100.0, -5",
		    "-100.0, 5",
		    "-50.0, -2"
		})
		void testNegativePriceAndQuantity(double price, int quantity) {
		    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
		        orderservice2.calPrice(price, quantity);
		    });
	 }
	 
	 //methodsource -> getting values from method
	 //static method -> stream of values
	 
	 static Stream<Integer> vaildStockValues(){
		 return Stream.of(0,10,20,30);
	 }
	 
	 @ParameterizedTest
	 @MethodSource("vaildStockValues")
	 public void testVaildStockValues(int stock) {
		 orderservice2.setStock(stock);
		 assertEquals(stock,orderservice2.getStock());
	 }
	 
	 //valuesource -> replace with method source
	 
	 static Stream<Arguments> testInputValues(){
		 return Stream.of(
				 org.junit.jupiter.params.provider.Arguments.of(100.00,2,180.0),
				 org.junit.jupiter.params.provider.Arguments.of(100.00,3,270.0),
				 org.junit.jupiter.params.provider.Arguments.of(100.00,4,360.0)
				 );
	 }
	 @ParameterizedTest
	 @MethodSource("testInputValues")
	 void testCalPrice_Parameterized(double price, int quantity, double expected) {
	        assertEquals(expected, orderservice2.calPrice(price, quantity));
	 //modify param test -> with method source
}
	 
	 	static Stream<Integer> boundaryOrderValues() {
		    return Stream.of(11, 13, 15);
		}
	
		@ParameterizedTest
		@MethodSource("boundaryOrderValues")
		void testBoundaryOrderPlace(int number) {
		    assertThrows(IllegalArgumentException.class, () -> {
		        orderservice2.placeOrder(number);
		    });
		}
		
		static Stream<Double> invalidDiscountValues() {
		    return Stream.of(-0.5, 1.5, 2.0);
		}
		
		@ParameterizedTest
		@MethodSource("invalidDiscountValues")
		void testInvalidDiscounts(double number) {
		    assertThrows(IllegalArgumentException.class, () -> {
		        orderservice2.setDiscount(number);
		    });
		}
		
		static Stream<Arguments> negativePriceAndQuantity() {
		    return Stream.of(
		        Arguments.of(100.0, -5),
		        Arguments.of(-50.0, -2)
		    );
		}	
		@ParameterizedTest
		@MethodSource("negativePriceAndQuantity")
		void testNegPriceNegQuan(double price, int quantity) {
		    assertThrows(IllegalArgumentException.class, () -> {
		        orderservice2.calPrice(price, quantity);
		    });
		}
		
}
