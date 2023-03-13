package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * TCP방식의 통신 프로그램으로 서버 역할을 한다.
 * 클라이언트와 연결이 완료되면 연결된 클라이언트에게 
 * 환영 메시지를 보낸다.
*/
public class TcpServer01 {
	public static void main(String[] args) throws IOException {
//		TCP소켓 통신을 위해 ServerSocket 객체를 생성한다,
		ServerSocket server = new ServerSocket(7777);

		System.out.println("접속을 기다린다.");

		// accept()
		// >> 클라이언트의 연결 요청이 올 때까지 계속 기다린다.
		// >> 클라리언트의 연결 요청이 오면 새로운 Socket객체를 생성해서
		// 클라이언트의 Socket 객체와 연결한다.
		Socket socket = server.accept();

		// 이 accept()메서드 명령을 기술한 이후의 내용은 클라이언트와 연결된 훙에
		// 처리할 내용들을 작성하면 된다.
		System.out.println("클라이언트와 연결되었습니다...");
		System.out.println();

		System.out.println("접속한 상대방(클라이언트) 정보..."); // 상대방 정보
		System.out.println("IP 주소 : " + socket.getInetAddress()); // InetAddress : IP정보를 관리하는 객체
		System.out.println("Port 번호 : " + socket.getPort());
		System.out.println();

		System.out.println("상대방과 접속이 완료된 현재 컴퓨터 정보...");// 자기자신 정보
		System.out.println("현재 컴의 IP 주소 : " + socket.getLocalAddress());
		System.out.println("현재 컴의 Port 번호 : " + socket.getLocalPort());
		System.out.println();
		System.out.println("---------------------------------------------------");

		// 상대방(클라이언트)에게 메시지 보내기
		// Socket객체 outputStream객체를 구해서 데이터를 전송한다.
		// (Socket객체의 getOutputStream()메서드 이용)
		OutputStream out = socket.getOutputStream(); // 바이트 기반의 스트림이라 한글 보내기가 어렵다 그래서 보조 스트림을 이용한다.
		DataOutputStream dout = new DataOutputStream(out);

		// 메세지 전송하기 >> 출력스트림을 이용해서 출력 작업을 한다.
		dout.writeUTF("환연합니다. 어서오세요");
		System.out.println("메시지를 보냈습니다...");

		// 소켓과 스트림 닫기
		dout.close();
		socket.close();
		server.close();

	}
}
