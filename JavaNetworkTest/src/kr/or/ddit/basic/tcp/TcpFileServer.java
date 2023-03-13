package kr.or.ddit.basic.tcp;

import java.io.*;
import java.net.*;

public class TcpFileServer {
    public static void main(String[] args) {
        final String SAVE_DIR = "d:/d_other/연습용"; // 파일을 저장할 폴더 경로
        final int PORT = 7777; // 서버 포트 번호

        try {
            // 1. 파일 저장 폴더를 갖는 File 객체 생성
            File saveDir = new File(SAVE_DIR);
            // 해당 폴더가 없으면 새로 생성
            if (!saveDir.exists()) {
                saveDir.mkdirs();
            }

            // 2. ServerSocket 객체 생성 후 클라이언트의 접속을 기다린다.
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("서버가 준비되었습니다.");

            // 클라이언트의 접속을 기다린다.
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트가 접속되었습니다.");

            // 4. 클라이언트가 보낸 '파일명'을 받는다.
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String filename = dis.readUTF();

            // 5. 저장할 파일 정보를 이용한 File 객체 생성
            File saveFile = new File(saveDir, filename);

            // 6. 저장할 파일 정보를 이용한 파일 출력용 스트림 객체 생성
            FileOutputStream fos = new FileOutputStream(saveFile);

            // 7. 클라이언트가 보낸 파일 데이터를 소켓에서 읽어서 파일로 출력하는 작업
            byte[] buffer = new byte[1024];
            int readBytes;
            while ((readBytes = socket.getInputStream().read(buffer)) > 0) {
                fos.write(buffer, 0, readBytes);
            }

            // 8. 저장 완료 후 스트림과 소켓을 닫는다.
            fos.close();
            dis.close();
            socket.close();

            System.out.println("파일이 저장되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}