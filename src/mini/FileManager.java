package mini;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 주문 이력을 파일에 저장하고 불러오는 클래스
public class FileManager {

	
	// final : 상수
	// static : 인스턴스 없이 사용 가능
	// 파일 이름은 프로그램이 끝날때까지 변하지 않음
	static final String FILE_NAME = "order.txt"; // => 고정값
	
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
			bufferedWriter.close(); // 닫기 + 버퍼비우기
			
			// 줄바꿈 (둘중 하나만 사용)
	//		bufferedWriter.writer("\n");
			bufferedWriter.newLine(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
