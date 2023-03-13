package ko.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);

		System.out.println(list1);
		System.out.println(list1.size());

		System.out.println(list1.get(1));

		list1.add(3, "zzz");
		System.out.println(list1);

		String sTemp = (String) list1.set(3, "yyy");
		System.out.println(sTemp);
		System.out.println(list1);

		list1.remove(3);
		System.out.println(list1);

		list1.remove("bbb");
		System.out.println(list1);

		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

		for (String str : list2) {
			System.out.println(str);
		}

		System.out.println("---------------------------------------------------");

		// contains(비굑개체) ==> 리스트에 저장된 데이터 중에서 비교객체가 있으면 true 없으면 false 반환
		System.out.println("DDDD값 존재 여부 : " + list2.contains("DDDD"));
		System.out.println("DDDD값 존재 여부 : " + list2.contains("ZZZZ"));

		// indexof(비교객체)
		// lastIndexOf(비교객체) 리스트에 비교객체가 있으면 비교객체가 저장된 index값을 반환하고 없으면 -1을 반환한다.

		// - indexOf()는 검색 방향이 앞에서부터 뒤쪽으로 검색하고
		// lastindexOf()메서드는 뒤에서 앞쪽으로 검색한다
		// - 비교객체가 많으면 검색해서 첫번째로 찾아진 데이터의 위치값으 반환한다.
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		System.out.println(list2);
		System.out.println("DDDD의 위치값 : " + list2.indexOf("DDDD"));
		System.out.println("ZZZZ의 위치값 : " + list2.indexOf("ZZZZ"));

		System.out.println("DDDD의 위치값 : " + list2.lastIndexOf("DDDD"));
		System.out.println("ZZZZ의 위치값 : " + list2.lastIndexOf("ZZZZ"));
		System.out.println("---------------------------------------------------");

		// - toArray() ==> 리스트 안의 데이터를 배열로 반환해서 반환한다.
		// ==> 기본적으로 Object형 배열로 변환한다.

		// toArray(new 제네릭 타입명[0]) ==>제네릭 타입의 배열로 변환해서 반환한다.

		Object[] strArr = list2.toArray();
//		String []strArr = (String[])list2.toArray(); 
		System.out.println("배열의 개수 : " + list2.size());
		System.out.println("배열의 개수 : " + strArr.length);

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i + "번째 자료 : " + strArr[i]);
		}
		System.out.println("---------------------------------------------------");
		//제네릭 타입의 배열로 변환해서 가져오기 
		String[] strArr2 = list2.toArray(new String[0]);
		for( String str : strArr2) {
			System.out.println(str);
		}
	}
}
