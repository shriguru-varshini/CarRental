package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderServiceTest1 {

	//@Test -> testInsufficientStock ->asserThrows
	//@Test -> calculate total ->price , quantity -> expected
	
	OrderService os = new OrderService();
	@Test 
	void testInsufficientStock() {
		
		IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, ()->{
			os.placeOrder(15);
		});
	}
	
	@Test 
	void calculatetotal() {
		os.calPrice(10, 5);//price, quantity
		assertEquals(45,os.calPrice(10, 5));
	}
	
	@Test
	void SufficientStock() {
		assertTrue(os.placeOrder(5)); // if result = +ve
	}
	
	@Test
	void InSufficientStock()
	{
		assertTrue(os.placeOrder(10));
	}
	
	@ParameterizedTest //same test , diff set of data
	@CsvSource ({
		"10, 2, 18",
		"20, 3, 54",
		"15, 2, 27",
		"70, 1, 63"
	})
	//a b expected
	void testAddParamCsv(double price, int quantity,int expected) { // arug -> from valuesource
		assertEquals(expected, os.calPrice(price,quantity));
		//runs for 4 sets
	}
	
	@Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(1000),() -> {
			
			//simulate
			Thread.sleep(500);
			os.calPrice(10, 1);	
		});
	}
	
	@Test
	void test0() {
		assertEquals(0, os.calPrice(50, 0));
	}
	
	//multithread test
	
	@Test
	void testPlaceOrderMultithread() throws InterruptedException {
		Thread thread1 = new Thread(() ->os.placeOrder(2));
		Thread thread2 = new Thread(() ->os.placeOrder(1));
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		assertEquals(7,os.getStock());
	}
	
	
	@BeforeAll
    public static void beforeAllTests() {
        System.out.println("Testing Started");
    }
 
    @AfterAll
    public static void afterAllTests() {
        System.out.println("All Tests Completed");
    }
    @AfterEach
    public void afterEachTest() {
        System.out.println("Test Completed");
    }

    @Test
    @Disabled("Test disabled for demonstration purposes")
    public void testDisabled() {
        System.out.println("This test is disabled and will not run");
    }

}
