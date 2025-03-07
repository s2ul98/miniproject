package mini;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) throws IOException {
		
		FileWriter writer = new FileWriter("order.txt");
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
	            System.out.println("1. 상품 주문하기");
	            System.out.println("2. 전체 주문 이력보기");
	            System.out.println("3. 고객별 주문 이력 보기");
	            System.out.println("4. 특정 날짜에 들어온 주문 이력보기");
	            System.out.println("5. 끝내기");
	            System.out.print("옵션을 선택하세요: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();     
	            
	            switch (choice) {
	            
	  
		}
	            
	//            System.out.print("주문번호: " + orderId + "고객: " + customerName + ", 상품: " + product + ", 수량: " + quantity + ", 가격: " + price + ", 주문 날짜: " + orderDate);

	            
	            
	            
		}
	}
}
//class Order {
//	int orderId;
//	String customerName;
//	String product;
//	int quantity;
//	int price;
//	LocalDateTime orderDate;
//	
//	public Order(int orderId, String customerName, String product, int quantity, int price, LocalDateTime orderDate) {
//		super();
//		this.orderId = orderId;
//		this.customerName = customerName;
//		this.product = product;
//		this.quantity = quantity;
//		this.price = price;
//		this.orderDate = orderDate;
//	}
//
//	@Override
//	public String toString() {
//		return "주문번호: " + orderId + "고객: " + customerName + ", 상품: " + product + ", 수량: " + quantity + ", 가격: " + price + ", 주문 날짜: " + orderDate;
//	}
//	
//
//	
//	
//}
