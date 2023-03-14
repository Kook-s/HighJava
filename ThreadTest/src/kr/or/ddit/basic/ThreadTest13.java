//package kr.or.ddit.basic;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
///*
// * 10마리의 말들이 경주하는 프로그램 작성하기
// * 말은 Horse라는 이름의 쓰레드 클래로 작성하는데
// * 이 클래스 말이름(String), 등수(int), 현재위치(int)를 맴버변수로 갖는다.
// * 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준을 갖고 있다.
// * (Comparable 인터페이스 구현)
// * 
// *  경기 구간은 1~50 구간으로 되어 있다.
// * 경기가 끝나면 등수 순으로 출력한다.
// *  
// * 경기 중간 중간에 각 말들의 위치를 아래와 같이 출력한다.
// *예시)
// *말이름01 : --->------------------------------------------------
// *말이름02 : -------->-------------------------------------------
// *말이름03 : ------>---------------------------------------------
// *.....
// *말이름10 : ------------------>---------------------------------
//*/
//public class ThreadTest13 {
////	public static void print() {
////
////		for (int i = 1; i <= 50; i++) {
////			if (Horse.place == i)
////				System.out.print(">");
////			else
////				System.out.print("-");
////		}
////
////	}
//
//	public static void main(String[] args) {
//		Horse[] horse = new Horse[10];
//
//		List<Horse> ths = new ArrayList<>();
//
//		for (int i = 1; i < 10; i++) {
//			ths.add(new Horse("0"+i + "번 말"));
//		}
//		ths.add(new Horse("10번 말"));
//		for (Horse ho : ths) {
//			ho.start();
//		}
//		while (true) {// 현재 달리고 있는 위치
//			for (int i = 0; i < ths.size(); i++) {// 말의 개수만큼
//				System.out.print(ths.get(i).name + " : ");
//				for (int j = 1; j <= 50; j++) {
//					if (ths.get(i).place == j) {// i번째 위치가 j와 같으면
//						System.out.print(">");// >로 변환
//						continue;// 하고 첫번째 for 문으로 올라가서
//					}
//					System.out.print("-");// -를 출력?
//				}
//				System.out.println();
//			}
//			try {
//				Thread.sleep(500);// 0.5초의 시간 딜레이
//			} catch (InterruptedException e) {
//			}
//
//			int exitCnt = 0;// 스레드 갯수
//			for (int i = 0; i < ths.size(); i++) {
//				if (ths.get(i).getState() == Thread.State.TERMINATED) {// 스레드의 상태가 종료되었을때
//					exitCnt++;// 스레드의 갯수를 증가시킴
//				}
//			}
//			if (exitCnt == 10) {// 10번말이 모두 끝났을때는 끝남
//				break;
//			}
//			System.out.println("\n=========================================================\n");
//			// 끝나지 않았으면 출력
//		}
//
//		System.out.println();
//		Collections.sort(ths);//정렬한것
//		System.out.println("===경기결과===");
//		for (Horse h : ths) {// 리스트를 h에 넣고
//			System.out.println(h);// h출력
//		}
//
//	}
//}
//
//class Horse1 extends Thread implements Comparable<Horse> {
//	public static int setRank = 1;
//	public String name;
//	public int rank;
//	public int place;
//
//	public Horse(String name) {
//		this.name = name;
//	}
//
//	@Override
//	public void run() {
//		Random rnd = new Random();
//		for (int i = 0; i < 50; i++) {
//			place = i;
////			System.out.println(name +"번 마 "+location);
//			if (place == 50)
//				rank++;
//			try {
//				Thread.sleep(rnd.nextInt(400)); // 일시 정지 시간을 난수로 지정한다.
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		System.out.println(name + "경기 완료");
//		rank = setRank++;
//		System.out.println(rank + "등");
//	}
//
//	@Override
//	public int compareTo(Horse h) {
//		// TODO Auto-generated method stub
//		return this.rank-h.rank;
//	}
//
//	@Override
//	public String toString() {
//		return name + " : " + rank + "등 ";
//	}
//}
//
////class HorseLocation extends Thread {
////	private Horse ho;
////	
////	public HorseLocation(Horse ho) {
////		super();
////		this.ho = ho;
////	}
////
////	@Override
////	public void run() {
////		for (int i = 1; i <= 50; i++) {
////			if (Horse.location == i)
////				System.out.print(">");
////			else
////				System.out.print("-");
////		}
////
////		try {
////			Thread.sleep(1000); 
////		} catch (InterruptedException e) {
////			// TODO: handle exception
////		}
////
////	}
////}
