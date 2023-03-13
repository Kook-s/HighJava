package kr.or.ddit.basic;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOTest {
	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");

			// 자료형 단위로 출력할보조스트림 객체생성
			DataOutputStream dout = new DataOutputStream(fout);

			dout.writeInt(200); // 정수형 데이터 출력
			dout.writeFloat(123.45f);
			dout.writeBoolean(true);
			dout.writeUTF("ABCDabcd");

			System.out.println("출력 완료...");
			System.out.println("-------------------------------");
			dout.close();
			// -------------------------------------------------

			// 출력한 문자 읽어오기
			DataInputStream din = new DataInputStream(new FileInputStream("d:/d_other/test.dat"));

			// DataInputStream으로 자료를 읽어올 때는 출력할 때오 ㅏ순서와 구조가 같아야 한다.
			System.out.println("정수형 : " + din.readInt());
			System.out.println("실수형 : " + din.readFloat());
			System.out.println("논리형 : " + din.readBoolean());
			System.out.println("문장형 : " + din.readUTF());

			System.out.println();
			System.out.println("읽기 작업 완료...");

			din.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
