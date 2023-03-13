package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가
제일 긴 별명을 출력하시오
(길이 같에 입력가능)*/
public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		int temp = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번째 사람 입력 : ");
			list.add(sc.next());
		}

		for (String str : list) {
			if (temp < str.length()) {
				temp = str.length();
			}
		}

		for (String str : list) {
			if (temp == str.length()) {
				System.out.println(str);
			}
		}
		sc.close();
	}
}
