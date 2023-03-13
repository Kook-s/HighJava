package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest {
	public static void main(String[] args) {
		/*
		 * List와 Set의 차이점 1.List - 데이터의 순서(index)가 있다. - 중복되는 데이터 저장할 수 있다.
		 * 
		 * 2.Set - 데이터의 순서(index)가 없다. - 중복되는 데이터 저장할 수 없다.
		 */
		HashSet hs1 = new HashSet();
		// Set에 데이터 추가할 때도 add() 메서드를 이용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);

		System.out.println("Set 데이터 hs1 => " + hs1);
		System.out.println("Set의 개수 hs1 => " + hs1.size());
		System.out.println();
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("Set 데이터 hs1 => " + hs1);
		isAdd = hs1.add("CC");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("Set 데이터 hs1 => " + hs1);
		System.out.println();

		// Set의 데이터를 수정하는 메서드가 없다||list는 List.set(index, 새로운 데이터)
		// 그래서 수정하는 방법은 해당자료를 삭제한 후에 추가행 주는 방법을 사용한다.

		// Set의 데이터 삭제하기 ==> remove(삭제할 자료) ==> 반환값 : 삭제 성공 true , 실패 false
		// ==> clear() ==> 전체 데이터 삭제

		// 예)
		isAdd = hs1.remove("FF");
		System.out.println("삭제 후 Set => " + hs1);
		hs1.add("EE");
		System.out.println("Set 데이터 hs1 => " + hs1);
		System.out.println();
//		hs1.clear();
//		System.out.println("Set 데이터 hs1 => " + hs1);

		/*
		 * Set의 데이터ㅏ는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다. 그래서 데이터를 하나씩
		 * 차례로 얻기 위해서는 Iterator형 객체로 변환해야 한다. Set형의 데이터들를 Iterator형 객체로 변환하는 메서드
		 * ==>iterator()
		 */

		Iterator it = hs1.iterator(); // Set데이터를 Iterator로 변환하기
		/*
		 * Iterator의 hasNext() 메서드 Iterator의 포인터가 가리키는 곳의 다음번째 데이터가 있는지 검사한다. 데이터가 있으면
		 * true 없으면 false 반환
		 */
		while (it.hasNext()) {
			/*
			 * Iterator의 next() 메서드 ==> Iterator의 포인터를 다음번째 위치로 이동시킨 후 그곳의 데이터 꺼내서 반환한다.
			 */
			System.out.print(it.next() + " ");
		}
		System.out.println();

		// foreach문을 이용하여 데이터를 차레로 가져오기
		for (Object obj : hs1) {
			System.out.print(obj + " ");
		}
		System.out.println();
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자
		// 번호는 1부터 28까지 있고, 추첨할 인원이 3명이다.
		// 당첨번호를 출력하시오.

		Random random = new Random();
//		int num = random.nextInt(28)+1;
//		System.out.println(num);
		HashSet hashTest = new HashSet<>();
		while (hashTest.size() < 3) {
			hashTest.add(random.nextInt(28) + 1);
		}
		System.out.println("당첨자 번호: " + hashTest);
		System.out.println();
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> arrayList = new ArrayList<>(hashTest);
		System.out.println("List데이터 출력");
	for(int i=0;i<arrayList.size();i++) {
		System.out.print(arrayList.get(i)+" ");
	}
		
		
		
		
		

	}
}
