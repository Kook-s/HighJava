package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest {
	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 Buffered스트림을 사용한다.
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;

		try {
			fout = new FileOutputStream("d:/d_other/bufferTest.txt");

			// 버퍼의 크기가 5인 버퍼스트림 객체 생성
			bout = new BufferedOutputStream(fout, 5);

			for (char ch = '1'; ch <= '9'; ch++) {
				bout.write(ch);
			}
			// 출력 작업이 끝나면 출력 버펑 남아 있는 데이터를 강제로 모두 출력시켜줘야 한다.
			//bout.flush();
			System.out.println("작업 끝...");
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			/*
			 * if (fout != null) try { bout.close(); } catch (IOException e) { // TODO:
			 * handle exception }
			 */ //보조스트림을 닫으면 보조 스트림에서 사용한 기반이 된느 스트림도 같이 닫힌다.

			if (bout != null)
				try {
					bout.close();
					//flush 기능이 내장되었다 그래도 작업이 끝나고 다음에 해주는 것이 안전하고 좋다
				} catch (IOException e) {
					// TODO: handle exception
				}
		}
	}
}
