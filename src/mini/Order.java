package mini;

import java.time.LocalDateTime;

public class Order {

	int orderNo; // 주문번호
	String customerName; // 고객명
	String productName; // 제품명
	int productCnt; // 제품 수량
	int productPrice; // 제품 가격
	LocalDateTime orderDate; // 주문일
	
	// 주문번호는 나중에 처리
	public Order(String customerName, String productName, int productCnt, int productPrice) {
		super();
		this.customerName = customerName;
		this.productName = productName;
		this.productCnt = productCnt;
		this.productPrice = productPrice;

	
		// 주문일은 현재시간을 저장
		this.orderDate = LocalDateTime.now();
	}
	
	// toString 함수 재정의
	// 주문 이력을 문자열로 반환
	@Override
	public String toString() {
		
		String str = String.format("주문번호: %d, 고객명: %s, 제품명: %s, 주문수량: %d, 가격: %d, 주문일: %s", orderNo,customerName, productName, productCnt, productPrice, productPrice, orderDate);
		
		return str;
	}
	

	
	
	}

