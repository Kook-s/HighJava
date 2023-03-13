package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();

		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));

		System.out.println("정렬전...");

		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------");
		Collections.sort(memList);
		System.out.println("정렬후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------");
		// 회원 번호 기준으로 내림차순 정렬
		// ==> 외부정렬 기준 클래스를 작성하여 처리한다.

		Collections.sort(memList, new SortNumDesc());
		for (Member mem : memList) {
			System.out.println(mem);
		}
//		System.out.print(memList);

	}
}

//Member 클래스의 회원이름를 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
//Comparable 인터페이스 구현
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;

	public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	public int compareTo(Member mem) {
		// 회원이름의 오름차순
		return this.getName().compareTo(mem.getName());
		
	}

}

//Member의 회원번호(num)의 내림차순으로 정렬하는 외부 정렬 기준 클래스 
class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		if (mem1.getNum() > mem2.getNum()) {
			return -1;
		} else if (mem1.getNum() < mem2.getNum()) {
			return 1;
		}
		return 0;
		// Wrapper 클래스 이용하는 방법1
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		// Wrapper 클래스 이용하는 방법2
//		return new Integer.compare(mem1.getNum(),mem2.getNum())*-1;
		// Wrapper 클래스 이용하는 방법3
//		return mem2.getNum()-mem1.getNum();

//		if (new Integer(mem1.getNum()).compareTo(new Integer(mem2.getNum())) > 0) {
//			return -1;
//		} else if (new Integer(mem1.getNum()).compareTo(new Integer(mem2.getNum())) < 0) {
//			return 1;
//		}
//		return 0;
	}

}
