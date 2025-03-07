package mini;

import java.util.Scanner;

// 사용자의 입력을 받아서 처리하는 메인 프로그램
public class Main {

	public static void main(String[] args) {
		
		// Scanner : 보조 클래스
		// 키보드를 통해 값을 입력받는 클래스
		Scanner scanner = new Scanner(System.in);
		
		// 1~5 중에서 하나를 입력받아 명령을 처리하다가 5가 입력되면 프로그램 종료
		while(true) {
			 System.out.println("1. 상품 주문하기");
	         System.out.println("2. 전체 주문 이력보기");
	         System.out.println("3. 고객별 주문 이력 보기");
	         System.out.println("4. 특정 날짜에 들어온 주문 이력보기");
	         System.out.println("5. 끝내기");
	         System.out.print("옵션을 선택하세요: ");
	         
	         // nextInt : 숫자를 입력받는 함수
	         int choice = scanner.nextInt();
	         scanner.nextLine(); //버퍼비우기
	         
	         // 1 + 엔터를 입력할때 1은 choice에 저장되고 공백문자가 버퍼에 남아있음
	         // 그래서 뒤에서 nextLine을 호출했을때 공백문자가 입력되어 바로 처리 됨
	         
	         if(choice == 1) {
	        	 
	        	 // 주문번호, 주문일 x
	        	 // 주문자명, 상품명, 상품수량, 상품가격 입력받기
	        	 
	        	 System.out.println("고객명: ");
	        	 String customerName = scanner.nextLine();
	        	 
	        	 System.out.println("상품명: ");
	        	 String productName = scanner.nextLine();
	        	 
	        	 System.out.println("상품수량: ");
	        	 int productCnt = scanner.nextInt();
	        	 
	        	 System.out.println("상품가격: ");
	        	 int productPrice = scanner.nextInt();
	        	 
	        	 // 상품 주문 정보 생성
	        	 Order order = new Order(customerName, productName, choice, choice);
	        	 System.out.println(order);
	        	 
	        	 // 파일에 주문 이력 쓰기
	        	//  FileManager.saveOrder(order);
	        	 
	         } else if(choice == 2) {
	        	 FileManager.readOrders();
	         } else if(choice == 3) {
	        	 
	         } else if(choice == 4) {
	        	 
	         } else if(choice == 5) {
	        	 System.out.println("프로그램을 종료합니다.");
	        	 break; // 반복문 종료
	         } else {
	        	 System.out.println("잘못된 숫자가 입력되었습니다.");
	         }
		}

	}

}
