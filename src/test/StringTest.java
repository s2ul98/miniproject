package test;

public class StringTest {

	public static void main(String[] args) {
	
		// format : 특정형식에 맞게 문자열을 가공하는 함수
		// %s : 문자열 자리
		// %d : 정수 자리
		String str = String.format("이름: %s, 나이: %d", "둘리", 10);
		System.out.println(str);

	}

}
