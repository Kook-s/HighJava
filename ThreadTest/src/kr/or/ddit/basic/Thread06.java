package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class Thread06 {
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();

		th1.start();
		th2.start();
	}
}

class DataInput extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언 - 두 쓰레드에서 공통으로 사용할 변수
	public static boolean isInputCheck = false;

	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		isInputCheck = true;
		System.out.println("입력한 값 : " + str);
	}
}

class CountDown extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되었으면 쓰레드를 종료시킨다.
			if (DataInput.isInputCheck == true) {
				System.out.println("입력이 완료 되었습니다.");
				return; // run()메소드가 종료되면 해당 쓰레드가 종료되는 거랑 똑같다.
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("시간이 초과되었습니다. 프로그램을 멈춥니다.");
		System.exit(0);
	}
}