package Junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

public class OrderServiceTestSuit {
	
	@Suite
	@SelectClasses({
		OrderServiceTest1.class,
		OrderService2Test.class,
	})
	public class OrderServiceTestSuite{
		
		
	}

}
