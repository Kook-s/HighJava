package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 * 사용자의 가위 바위 보는 showInputDualog()메서드를 이용하여 입력
 * 
 * 입력시간은 5초로 제한하고 카운트 다운을 진행 한다.
 * 5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 * 
 * 5초 안에 입력이 완료되면 승패를 구해서 출력한다.
 * 
 * 겨로가 예시) 
 * 1) 5초안에 입력하지 못했을 경우
 *  -- 결과 --
 *  시간 초과로 당신이 졌습니다.
 *  
 * 2) 5초안에 입력했을 경우
 * -- 결과 --
 * 컴퓨터 : 가위 
 * 사용자 : 바위
 * 결 과 : 당신이 이겼습니다.
 * 
*/
public class ThreadTest07 {
	public static void main(String[] args) {

		Thread th1 = new RockScissorsPaper();
		Thread th2 = new rspCountDown();

		th1.start();
		th2.start();
		
	}
}

class RockScissorsPaper extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언 - 두 쓰레드에서 공통으로 사용할 변수
	public static boolean isInputCheck = false;
	Random ran = new Random();
	String pc[] = { "가위", "바위", "보" };
	String pcValue = pc[ran.nextInt(3)];

	@Override
	public void run() {
		
		String str;
		do {
			str = JOptionPane.showInputDialog("가위 바위 보 입력하시오");
		} while (!("가위".equals(str)||"바위".equals(str)||"보".equals(str)));
		
		isInputCheck = true;
		System.out.println("--- 결과 ---");
		System.out.println("사용자 : " + str);
		System.out.println("컴퓨터 : " + pcValue);
			
		if (isInputCheck) {
			if (str.equals(pcValue)) {
				System.out.println("비겼습니다");
			} else if (str.equals("가위") && pcValue.equals("보") || str.equals("바위") && pcValue.equals("가위")
					|| str.equals("보") && pcValue.equals("바위")) {
				System.out.println("당신이 이겼습니다.");
			} else {
				System.out.println("당신이 졌습니다.");
			} 
		}

	}
}

class rspCountDown extends Thread {

	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (RockScissorsPaper.isInputCheck == true) {
				return; 
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("--- 결과 ---");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}