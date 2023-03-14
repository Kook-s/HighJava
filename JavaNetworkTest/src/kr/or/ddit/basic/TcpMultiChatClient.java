package kr.or.ddit.basic.udp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	public static void main(String[] args) {
		new TcpMultiChatClient().clienStart();
	}

	public void clienStart() {
		Socket socket = null;

		try {
			socket = new Socket("192.168.146.58", 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			// --------------------------------------------------

			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);

			sender.start();
			receiver.start();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}// clientStart 메서드 끝

	// -----------------------------------------------------------
	// 전송용 쓰레드
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		private String name;
		private Scanner scan;

		// 생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
			try {
				din = new DataInputStream(this.socket.getInputStream());
				dout = new DataOutputStream(this.socket.getOutputStream());
				if (din != null) {
					while (true) {
						// 클라이언트용 프로그램 처음 실행되면 서버에 접속하고 접속에 성공하면
						// 첫번째로 '대화명'을 입력받아 전송하고, '대화명'의 중복여부를 응답으로 받아서 확인한다.
						System.out.print("대화명>> ");
						String name = scan.nextLine();
						dout.writeUTF(name); // 대화명을 서버로 전송
						// 대화명 중복여부를 응답으로 받는다.
						String feedBack = din.readUTF();
						// 붕족 여부 확인하기
						if ("대화명 중복".equals(feedBack)) {// 대화명이 중복될 때의 경우...
							System.out.println(name + "은 중복되는 대화명입니다...");
							System.out.println("다른 대화명을 입력하세요.");
						} else {// 대화명이 중복되지 않았을 경우
							this.name = name;
							System.out.println("[" + name + "]" + "대화명으로 대화방에 입장했습니다...");
							System.out.println();
							break;
						}
					} // while문끝
				} // if문 끝

			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자 끝...

		@Override
		public void run() {
			try {
				while (dout != null) {
					dout.writeUTF("[" + this.name + "]" + scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	// 수신용 쓰레드
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자 끝

		@Override
		public void run() {
			try {
				while (din != null) {
					// 서버에서 받은 메시지를 화면에 출력한다.
					System.out.println(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
