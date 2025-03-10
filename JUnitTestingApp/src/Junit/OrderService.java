package Junit;

public class OrderService {
	
	private int stock=10;
	private double discount=0.10; //10%
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	//cal order price
	public double calPrice(double price,int quantity) {
		return price*quantity*(1-discount);
	}
	
	public boolean placeOrder(int quantity) {
		if(quantity >stock) {
			throw new IllegalArgumentException("Insufficient stock");
		}
		stock -=quantity;
		return true;
	}

	//crt orderservicetest class
	//@Test -> testInsufficientStock ->asserThrows
	//@Test -> calculate total ->price , quantity -> expected
}
