package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Example {

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
