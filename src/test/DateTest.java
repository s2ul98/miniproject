package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 날짜 조회, 포맷팅, 변환
public class DateTest {

	public static void main(String[] args) {
		
		// 날짜를 저장하는 클래스 : Date LocalDateTime
		// now : 현재시간을 조회하는 함수
		LocalDateTime currenDate = LocalDateTime.now();
		System.out.println(currenDate);

		// 국제 날짜 ㅍ준 : ISO8601
		// DateTimeFormatter : 날짜와 시간의 형식을 지정할때 사용하는 클래스
		// ofPattern : 특정 패턴으로 날짜를 표현하는 함수
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = currenDate.format(formatter);
		System.out.println(formattedDate); // 2025-03-07 14:13:14
		
		// String -> LocalDateTime 변환
		String str = "2025-03-07 14:00:00";
		// 원본 데이터, 패턴
		LocalDateTime parseDate = LocalDateTime.parse(str, formatter);
		System.out.println(parseDate); // 2025-03-07T14:00
		
		// String -> LocalDate
		// LocalDate : 날짜만 저장하는 클래스 (시간x)
		// LocalTime : 시간만 저장하는 클래스
		String str2 = "2025-0307";
		LocalDate parseDate2 = LocalDate.parse(str2); //패턴x
		System.out.println(parseDate2);
		
	}

}
