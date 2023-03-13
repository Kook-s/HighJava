package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트가 보내온 파일을 받아서 "d:/d_other/연습용" 폴터에 저장한다.
public class TcpFileServer {
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}

	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;

		DataInputStream din = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		// 저장할 폴더 정보를 갖는 File 객체 생성
		File saveDir = new File("d:/d_other/연습용");
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}

		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			socket = server.accept(); // 클라이언트의 요청 기다리기...

			System.out.println("파일 수신 시작...");

			// 클라이언트가 첫번째로 보낸 데이터(파일명)를 받을 스트림 객체 생성
			din = new DataInputStream(socket.getInputStream());

			String fileName = din.readUTF();

			// 저장할 폴더와 수신받은 파일명을 결합한 File객체 생성
			File saveFile = new File(saveDir, fileName);

			bin = new BufferedInputStream(socket.getInputStream());// 수신용
			bout = new BufferedOutputStream(new FileOutputStream(saveFile)); // 파일 저장용

			byte[] temp = new byte[1024];
			int len = 0;

			while ((len = bin.read(temp)) > 0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			System.out.println("파일 수신완료...");

		} catch (Exception e) {
			System.out.println("파일 수신 실패!!!");
		} finally {
			if (din != null)
				try {
					din.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			if (bin != null)
				try {
					bin.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			if (bout != null)
				try {
					bout.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			if (socket != null)
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			if (server != null)
				try {
					server.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}

		}

	}
}

//final String SAVE_DIR = "d:/d_other/연습용"; // 파일을 저장할 폴더 경로
//final int PORT = 7777; // 서버 포트 번호
//
//try {
//    // 1. 파일 저장 폴더를 갖는 File 객체 생성
//    File saveDir = new File(SAVE_DIR);
//    // 해당 폴더가 없으면 새로 생성
//    if (!saveDir.exists()) {
//        saveDir.mkdirs();
//    }
//
//    // 2. ServerSocket 객체 생성 후 클라이언트의 접속을 기다린다.
//    ServerSocket serverSocket = new ServerSocket(PORT);
//    System.out.println("서버가 준비되었습니다.");
//
//    // 클라이언트의 접속을 기다린다.
//    Socket socket = serverSocket.accept();
//    System.out.println("클라이언트가 접속되었습니다.");
//
//    // 4. 클라이언트가 보낸 '파일명'을 받는다.
//    DataInputStream dis = new DataInputStream(socket.getInputStream());
//    String filename = dis.readUTF();
//
//    // 5. 저장할 파일 정보를 이용한 File 객체 생성
//    File saveFile = new File(saveDir, filename);
//
//    // 6. 저장할 파일 정보를 이용한 파일 출력용 스트림 객체 생성
//    FileOutputStream fos = new FileOutputStream(saveFile);
//
//    // 7. 클라이언트가 보낸 파일 데이터를 소켓에서 읽어서 파일로 출력하는 작업
//    byte[] buffer = new byte[1024];
//    int readBytes;
//    while ((readBytes = socket.getInputStream().read(buffer)) > 0) {
//        fos.write(buffer, 0, readBytes);
//    }
//
//    // 8. 저장 완료 후 스트림과 소켓을 닫는다.
//    fos.close();
//    dis.close();
//    socket.close();
//
//    System.out.println("파일이 저장되었습니다.");
//
//} catch (IOException e) {
//    e.printStackTrace();
//}