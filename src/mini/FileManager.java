package mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 주문 이력을 파일에 저장하고 불러오는 클래스
public class FileManager {

	
	// final : 상수
	// static : 인스턴스 없이 사용 가능
	// 파일 이름은 프로그램이 끝날때까지 변하지 않음
	static final String FILE_NAME = "test.txt"; // => 고정값
	
	// 파일에 주문이력을 쓰는 메소드
	// 매개변수 : 주문이력
	public static void saveOrder(Order order) {
		
		// 출력스트림
		// 파일이름, 옵션(파일을 이어서 작성)
		try {
			FileWriter writer = new FileWriter(FILE_NAME, true);
			
			// 파일에 내용을 한줄씩 쓸 수 있도록 도와주는 보조 스트림
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(order.toString());
			bufferedWriter.newLine();
			
			bufferedWriter.close(); // 닫기 + 버퍼비우기
			
			// 줄바꿈 (둘중 하나만 사용)
	//		bufferedWriter.writer("\n");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ctrl + shife + o => 자동 import
		// 파일에서 주문이력을 읽어오는 메소드

		}
		
		
	public static List<Order> readOrders() {
		
		// 주문이력 리스트 생성
		List<Order> orders = new ArrayList<Order>();
		
		try {
			// 문자 기반 입력 스트림
			FileReader reader = new FileReader(FILE_NAME);
			
			// 파일의 내용을 한줄씩 읽어올 수 있도록 도와주는 보조 스트림
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			while(true) {
				// 주문이력이 한 줄씩 저장되어 있으므로 한 줄씩 읽어옴
				String line = bufferedReader.readLine();
				if(line == null) {
					break;
				}
				
				// 문자열을 Order 객체로 변환 (파싱)
				// 이유: 문자열은 통데이터여서 나중에 주문금액을 계산할 수 없음
				// 필요한 정보만 추출하기 위해 파싱이 필요함
				String[] arr = line.split(", "); 
				// [주문번호: 0, 고객명: 둘리, 제품명: 옷, 주문수량: 1, 가격: 1000, 주문일시: 2025-03-07 11:43:37]
				
				// 값만 다시 추출하기 위해 2차 파싱
//				String value1 = arr[0].split(": ")[1]; // [주문번호, 0]
//				String value2 = arr[1].split(": ")[1]; // [고객명, 둘리]
//				String value3 = arr[2].split(": ")[1]; // [제품명, 바지]
//				String value4 = arr[3].split(": ")[1]; // [주문수량, 1]
//				String value5 = arr[4].split(": ")[1]; // [가격, 15000]
//				String value6 = arr[5].split(": ")[1]; // [주문일시, 2025-03-07 11:43:37]
				
				// 타입에 맞게 변환
				int value1 = Integer.parseInt(arr[0].split(": ")[1]);  // 0 (string -> int)
				String value2 = arr[1].split(": ")[1]; // "둘리"
				String value3 = arr[2].split(": ")[1]; // "바지"
				int value4 = Integer.parseInt(arr[3].split(": ")[1]); // 1 (string -> int)
				int value5 = Integer.parseInt(arr[4].split(": ")[1]); // 15000 (string -> int)
				// String -> LocalDateTime
				String value6 = arr[5].split(": ")[1]; // 2025-03-07 11:43:37
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime localDateTime = LocalDateTime.parse(value6, formatter);
				
				// 주문이력 생성
				Order order = new Order(value1, value2, value3, value4, value5, localDateTime);
				
				// 리스트에 추가
				orders.add(order);
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	
	// 특정 회원의 주문 건수를 계산하는 함수
	// 매개변수 : 회원의 이름
	// 리턴값: 주문건수
	public static long getCountByCustomer(String customerName) {
		
		// 위에서 정의한 함수를 사용하여 파일에서 주문이력 조회
		List<Order> orders = readOrders();
		
		// 스트림을 이용하여 특정회원을 찾고 주문건수 구하기
		// filter : 스트림의 요소 중에서 특정 조건을 만족하는 요소만 추출 
		long count = orders.stream()
						   .filter(order -> order.customerName.equals(customerName))
						   .count();
		return count;
	}
	
	// 특정 회원의 총 주문금액을 계산하는 함수
	// 매개변수 : 회원의 이름
	// 리턴값 : 주문금액
	public static void getTotalPriceByCustomer(String customerName) {
		
		// 위에 있는 함수를 재사용하여 주문 리스트 조회
		List<Order> orders = readOrders();
		
		orders.stream()
			  .filter(order -> order.customerName.equals(customerName));
			//  .mapToInt(order -> order.)
	}
	public static void getOrderByDate(String date) {
		
		// 문자열을 LocalDate로 변환
		LocalDate localDate = LocalDate.parse(date);
		
		// 주문 이력 리스트 조회
		List<Order> orders = readOrders();
		
		// 스트림을 이용해서 특정일에 들어온 주문 이력만 조회
		orders.stream()
			  .filter(order -> localDate.equals(order.orderDate.toLocalDate()))
			  .collect(Collectors.toList());
	} 
}




