package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

//서버에 접속하면 "d:/d_other/펭귄.jpg"파일을 서버로 전송한다.
public class TcpFileClient {

	public static void main(String[] args) throws IOException {
		new TcpFileClient().clientStart();
	}

	public void clientStart() {
		Socket socket = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		DataOutputStream dout = null;

		// 전송할 파일 정보를 갖는 File객체 생성

		File file = new File("d:/d_other/펭귄.jpg");
		String fileName = file.getName();

		if (!file.exists()) {
			System.out.println("전송할 " + fileName + "파일이 없습니다.");
			return;
		}

		try {
			socket = new Socket("localhost", 7777);
			System.out.println("파일 전송 시작...");

			dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);

			// 파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));

			// 서버로 전송할 출력용 스트림 객체 생성
			bout = new BufferedOutputStream(socket.getOutputStream());

			byte[] temp = new byte[1024];
			int len = 0;

			// 파일 내용을 읽어서 서버로 전송한다.
			while ((len = bin.read(temp)) > 0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			System.out.println("파일 전송 완료...");

		} catch (Exception e) {
			System.out.println("파일 전송 실패!!");
		} finally {
			if (dout != null) {
				try {
					dout.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (bout != null) {
				try {
					bout.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (bin != null) {
				try {
					bin.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}

//String filePath = "d:/d_other/펭귄.jpg";
//
//// 전송할 파일 정보를 갖는 File 객체 생성
//File file = new File(filePath);
//
//// 전송할 파일이 있는지 검사해서 없으면 프로그램 종료
//if (!file.exists()) {
//    System.out.println("파일이 존재하지 않습니다.");
//    return;
//}
//
//// 서버와 연결
//Socket socket = new Socket("localhost", 7777);
//
//// 연결이 완료되면 첫번째로 파일명을 서버로 전송
//DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//dos.writeUTF(file.getName());
//
//// 파일의 내용을 읽기 위한 입력용 스트림 객체 생성
//FileInputStream fis = new FileInputStream(file);
//
//// 파일을 읽어서 소켓으로 출력하는 작업을 파일의 모든 내용이 전부 전송될 때까지 반복
//byte[] buffer = new byte[4096];
//int bytesRead = 0;
//while ((bytesRead = fis.read(buffer)) != -1) {
//    dos.write(buffer, 0, bytesRead);
//}
//
//// 전송이 완료되면 작업 끝
//fis.close();
//dos.flush();
//dos.close();
//socket.close();