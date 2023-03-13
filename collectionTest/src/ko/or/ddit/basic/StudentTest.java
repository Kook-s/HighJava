package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학 점수, 총점, 등수를 멤버로 갖는 student클래스를 만든다
 * 이 클래스의 생성자에서는 학번 이름 국,영,수 점수만을 인수로 받아서 초기화 처리 한다.
 * 
 * 이 Student객체는 List에 저장하여 관리한다.
 * 
 * List에 저장된 데티어들은 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 * 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준도 구현하여 
 * 정렬된 결과를 출력하시오.
 * 
 * (등수는 List에 전체 데이터가 추가된 후에 구해서 저장한다.) 
*/
public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student(7, "자바", 90, 80, 70));
		list.add(new Student(5, "오라클", 70, 85, 80));
		list.add(new Student(2, "코드", 90, 100, 90));
		list.add(new Student(1, "엑스코드1", 90, 90, 90));
		list.add(new Student(8, "엑스코드8", 90, 90, 90));
		list.add(new Student(3, "엑스코드4", 90, 90, 90));

		for (Student st1 : list) {
			int rank = 1;
			for (Student st2 : list) {
				if (st1.getTotalScore() < st2.getTotalScore()) {
					rank++;
				}
			}
			st1.setRank(rank);
		}

		Collections.sort(list);

		for (Student stu : list) {
			System.out.println(stu);
		}

		System.out.println();
		Collections.sort(list, new SortByTotal());
		for (Student stu : list) {
			System.out.println(stu);

		}
		System.out.println();

	}
}

class Student implements Comparable<Student> {
	private int stuNum;
	private String name;
	private int ko;
	private int en;
	private int ma;
	private int totalScore;
	private int rank;

	public Student(int stuNum, String name, int ko, int en, int ma) {
		super();
		this.stuNum = stuNum;
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.ma = ma;
		totalScore = this.ko + this.en + this.ma;
	}

	public int getStuNum() {
		return stuNum;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public int getKo() {
		return ko;
	}

	public void setKo(int ko) {
		this.ko = ko;
	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", name=" + name + ", ko=" + ko + ", en=" + en + ", me=" + ma
				+ ", totalScore=" + totalScore + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student st) {
		// TODO Auto-generated method stub
		if (this.getStuNum() > st.getStuNum())
			return 1;
		else if (this.getStuNum() < st.getStuNum())
			return -1;

		return 0;
	}
}

class SortByTotal implements Comparator<Student> {

//	@Override
//	public int compare(Student st1, Student st2) {
//		if (st1.getName().compareTo(st2.getName()) > 0) {
//			return 1;
//		} else if (st1.getName().compareTo(st2.getName()) < 0) {
//			return -1;
//		}
//		return 0;
//	}
	@Override
	public int compare(Student st1, Student st2) {
		if (st1.getTotalScore() == st2.getTotalScore()) {
			return st1.getName().compareTo(st2.getName());
		} 
		return Integer.compare(st1.getTotalScore(), st2.getTotalScore())*-1;
	}

}
