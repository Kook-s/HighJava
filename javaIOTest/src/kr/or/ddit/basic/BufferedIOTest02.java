package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			// 버퍼 스트림 객체 생성
			// 이클립스에서 자바 프로그램이 실행되는 현재 위치는
			// 실행중인 프로그램이 속한 프로젝트 폴더위치가 현재 위치가 된다.
			br = new BufferedReader(new FileReader("./src/kr/or/ddit/basic/FileTest01.java"));

			String temp = ""; // 읽어온 문자열이 저장될 변수

			// 문자기반의 입력용 버퍼 스트림은 데이터를 한 줄 단위로 읽어온느 메서드를 지원한다.
			// >> readLine()메서드 >> 더 이상 읽어올 데이터가 없으면 null 반환
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			
//			int j=1; 위에 폴문이랑 같은 의미
//			while((temp = br.readLine())!=null) {}
			
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (br != null)
				try {
					br.close();
					// flush 기능이 내장되었다 그래도 작업이 끝나고 다음에 해주는 것이 안전하고 좋다
				} catch (IOException e) {
					// TODO: handle exception
				}
		}
	}

}
