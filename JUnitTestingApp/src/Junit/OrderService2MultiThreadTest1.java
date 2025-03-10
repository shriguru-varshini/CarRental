package Junit;


import static org.junit.Assert.assertEquals;
 
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
public class OrderService2MultiThreadTest1 {
    private OrderService2 orderService2;
 
    @BeforeEach
    public void setUp() {
        orderService2 = new OrderService2();
    }
 
    @Test
    public void testPlaceOrderMultiThread() throws InterruptedException {
        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
 
        for (int i = 1; i <= threadCount; i++) {
            executor.execute(() -> {
                try {
                    orderService2.placeOrder(1);
                } catch (Exception ignored) {
                    // TODO: handle exception
                } 
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
 
        assertEquals(0, orderService2.getStock());
    }
}

