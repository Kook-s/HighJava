package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 * (컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9사이의 값 3개)
 * (스트라이크는 S, 볼은 B로 나타낸다.)
 * 
 * 예시)
 *  컴퓨터 난수 ==> 9 5 7
 *  
 * 실행예시)
 *  숫자 입력>> 3 5 6
 *  3 5 6 ==> 1S 0B
 *  숫자 입력>> 7 8 9
 *  7 8 9 ==> 0S 2B
 *  숫자 입력>> 9 7 5
 *  9 7 5 ==> 1S 2B
 *  숫자 입력>> 9 5 7
 *  9 5 7 ==> 3S 0B
 *  
 *  축하합니다...
 *  당신은 4번째 만에 맞췄습니다.
*/
public class BaseBallTest {
	private ArrayList<Integer> userList;
	private ArrayList<Integer> numList;
	Scanner scan = new Scanner(System.in);
	private int strike;
	private int ball;

	public static void main(String[] args) {
		System.out.println("****************************");
		System.out.println("  숫 자 야 구 게 임 시 작");
		System.out.println("****************************");
		System.out.println();
		System.out.println("1~9 사이의 서로 다른 숫자 3개를 입력하세요.\n");
		new BaseBallTest().ganeStart();
	}

	public void ganeStart() {
		createNum();
//		System.out.println("만들어 지는 난수 " + numList);
		int cnt = 0;
		do {
			cnt++;
			inputData();
			ballCount();
		} while (strike != 3);
		System.out.println();
		System.out.println("축하합니다...");
		System.out.println("당신은 " + cnt + "번째만에 맞췄습니다...");
	}

	public void createNum() {
		HashSet<Integer> numSet = new HashSet<>();
		Random random = new Random();

		while (numSet.size() < 3) {
			numSet.add(random.nextInt(9) + 1);
		}
		numList = new ArrayList<>(numSet);

		Collections.shuffle(numList);
	}

	public void inputData() {
		int num1, num2, num3;

		do {
			System.out.print("숫자 입력>> ");
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			num3 = scan.nextInt();
			if (num1 == num2 || num1 == num3 || num2 == num3) {
				System.out.println("중복되는 값이 입력되었습니다. 다시 입력하세요.");
			}
		} while (num1 == num2 || num1 == num3 || num2 == num3);

		userList = new ArrayList<>();
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
	}

	public void ballCount() {
		strike = 0;
		ball = 0;

		for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < numList.size(); j++) {
				if (userList.get(i) == numList.get(j)) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		System.out.println(userList.get(0) + ", " + userList.get(1) + ", " + userList.get(2) + " -->" + strike + "S "
				+ ball + "B");
	}
}
//내가 만든거 위에는 선생님이 만드신거 
//public class BaseBallTest {
//	public static void main(String[] args) {
//		HashSet<Integer> hashSet = new HashSet<Integer>();
//		Random random = new Random();
//		Scanner sc = new Scanner(System.in);
//		
//		int count = 0;
//		
//		while (hashSet.size() < 3) {//중복으로 2개만 입력된 경우가 있어 크기가 3이 될때 까지
//			hashSet.add(random.nextInt(9) + 1);
//		}
//		System.out.println("확인용 : "+hashSet);
//
//		ArrayList<Integer> list = new ArrayList<>(hashSet);
//
//		while (true) {
//			int s = 0;
//			int b = 0;
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print("입력하세요 >> ");
//				int num = sc.nextInt();
//				if (list.get(i) == num) {
//					s++;
//				} else {
//					for (int j = 0; j < list.size(); j++) {
//						if (list.get(j) == num) {
//							b++;
//
//						}
//					}
//				}
//			}
//			System.out.println("결과 >> "+s + "S, " + b + "B\n");
//			count++;
//			if (s == 3)
//				break;
//		}
//		System.out.println("축하합니다. "+count+"번째 만에 맞췄습니다.");
//
//	}
//}

