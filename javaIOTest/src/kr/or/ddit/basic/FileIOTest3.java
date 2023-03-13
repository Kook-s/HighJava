package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest3 {
	public static void main(String[] args) {
   //문자 기반 스트림을 이요하여 파일 내용 읽어와 출력하기
	FileReader fr = null;
	
	try {
		//스트림 객체 생성
		fr = new FileReader("d:/d_other/testChar.txt");
		int c;
		while((c=fr.read())!=-1) {
			System.out.print((char)c);
		}
	} catch (IOException e) {
		// TODO: handle exception
	}
	}
}
