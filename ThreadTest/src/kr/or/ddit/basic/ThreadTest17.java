package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 * Vector, Hashtable등의 예전부터 존재하던 Collection객체들은
 * 내부에서 동기화 처리가 된다.
 * 
 * 그런데 최근에 새로 구성된 Collection들은 동기화 처리가 되어 있지 않다.
 * 그래서 동기화가 필요한 프로그램에서 이런  Collection객체들을 사용하려면
 * 동기화 처리를 한 후에 사용해야 한다.
*/
public class ThreadTest17 {
	private static Vector<Integer> vec = new Vector<>();

	private static List<Integer> list = new ArrayList<>();
	private static List<Integer> list2 = Collections.synchronizedList( new ArrayList<>());

	public static void main(String[] args) {
//익명 구현체로 쓰레드 구현 
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++)
//					vec.add(i);
//					list.add(i);
					list2.add(i);
			}
		};

		Thread[] thArr = new Thread[] { new Thread(r), new Thread(r), new Thread(r), new Thread(r), new Thread(r) };
		for (Thread th : thArr) {
			th.start();
		}
		for (Thread th : thArr) {
			try {
				th.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//		System.out.println("vec의 개수 : " + vec.size());
//		System.out.println("list의 개수 : " + list.size());
		System.out.println("list의 개수 : " + list2.size());
	}
}
