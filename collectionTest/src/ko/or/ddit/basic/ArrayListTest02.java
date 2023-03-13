package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장 한 후에 
       이 ArrayList에 저장된 이름들 중에 '김'씨 성의 이름을 찾아 모두 출력하시오.
       (단, 입력은 Scanner객체를 이용한다.)

*/
public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번째 사람 입력 : ");
			list.add(sc.next());
		}
		
		System.out.println("김씨 성을 가진 사람들");
		// if(str.substring(0,1).equals("김"))
		// if(str.indexOf("김")==0)
		// if(str.startsWith("김"))
		for (String str : list) {
			if (str.charAt(0) == '김')
				System.out.print(str + " ");
		}
		sc.close();
	}

}
