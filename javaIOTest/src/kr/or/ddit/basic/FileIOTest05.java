package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileIOTest05 {
	public static void main(String[] args) {
		// 파일의 인코딩 방식을 지정해서 읽어오기

		try {
//		FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
//		FileReader fr = new FileReader("d:/d_other/test_utf8.txt");

			// 바이트 기반 스트림을 문자 기반 스트림으로 변환하는 클래스
			// InputStreamReader >> 입력용
			// OutputStreamWriter >> 입력용
			
			FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");
//			FileInputStream fin = new FileInputStream("d:/d_other/test_utf8.txt");
			
			//기본 인코딩으로 읽어온다.
//			InputStreamReader isr = new InputStreamReader(fin);
			
			//인코딩 방식을 지정해서 읽어온다.
			//- MS949 >> 윈도우의 기본 한글 인코딩방식 (ANSI방식과 같다)
			//- UFT-8 >> 유니코드 UTF-8 인코딩 방식
			//- US-ASCII >> 영문 전용 인코딩 방식
			InputStreamReader isr = new InputStreamReader(fin,"ms949");
//			InputStreamReader isr = new InputStreamReader(fin,"utf-8");

			int c;
			while ((c = isr.read()) != -1) {
				System.out.print((char) c);
			}

			isr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
