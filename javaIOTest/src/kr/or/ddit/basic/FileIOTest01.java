package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileIOTest01 {
	public static void main(String[] args) {
		// 바이트 기반의 파일 입력용 스트림으로파일 내용 일기

		FileInputStream fin = null; // 파일 입력용 스트림 객체 변수 선언
		try {
			// 읽어올 파일을 인수값으로 지정해서 FileInputStream객체 생성하기

			// 방법1
//	fin = new FileInputStream("d:/d_other/test.txt");

			// 방법2
			File file = new File("d:/d_other/test.txt");
			fin = new FileInputStream(file);

			int c; // 읽어온 데이터를 저장할 변수
			while ((c = fin.read()) != -1) {
				// 읽어온 데이터를 화면에 출력하기
				System.out.print((char) c);

			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("입출력 오류입니다...");
		} finally {
			if (fin != null)
				try {
					fin.close();
				} catch (IOException e) {
				}
		}

	}
}
