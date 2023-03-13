package ko.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고 
 * Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *-Map의 구조 : key값은 입력한 '이름'으로 사용하고 
 *              value값은 Phone클래스의 인스턴스로 한다
 *
 * -아래의 메뉴를 구현한다.
 * 1.전화번호 등록
 * 2.전화번호 수정
 * 3.전화번호 삭제
 * 4.전화번호 검색
 * 5.전화번호 전체  출력
 * 6.프로그램 종료 
 * 
 * 
 * - 추가 조건)
 * 1) 6. 전화전보 저장 메뉴를 추가하고 구현한다.
 *       (저장파일명은 phoneDate.bin)
 * 2) 프로그램이 시작될때 저장된 파일이 있으면 그 데이터를 일어와 Map에 저장한다
 * 3)프로그램을 종료할 때 Map의 데이터의 변화가 이씅면(데이터 추가,수정,삭제작업 
 * 후 저장하지 않은 상태) 자료를 저장한 후 종료되도록 한다.
*/


public class PhoneBookTest2 {
	HashMap<String, Phone> phoneBookMap;
	Scanner sc;

	public PhoneBookTest2() {
		phoneBookMap = new HashMap<>();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PhoneBookTest2().PhoneBookStart();
	}

	public void PhoneBookStart() {
		System.out.println("**********************************************");
		System.out.println("            전 화 관 리 프 로 글 램");
		System.out.println("**********************************************");
		System.out.println();
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				displayAdd();
				break;
			case 6:
				System.out.println(" 프로그램을 종료합니다.");
				break;

			default:
				System.out.println("번호를 잘못 입력했습니다.");
				break;
			}
		}

	}

	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >>");
		String name = sc.next();
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다.");
			return;
		}
		Phone p = phoneBookMap.get(name);
		System.out.println(name+"씨의 전화번호 정보");
		System.out.println("-------------------------------------");
		System.out.println("이름:"+p.getName());
		System.out.println("전화번호:"+p.getTel());
		System.out.println("주소:"+p.getAddr());
		System.out.println("-------------------------------------");
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >>");
		String name = sc.next();
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다.");
			return;
		}
		phoneBookMap.remove(name);
		System.out.println(name + "씨의 전화번호 정보가 삭제되었습니다.");

	}

	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >>");
		String name = sc.next();
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다.");
			return;
		}
		System.out.print("새로운 전화번호 >> ");
		String newTel = sc.next();

		System.out.print("새로운 주소 >> ");
		String newAddr = sc.next();

		phoneBookMap.put(name, new Phone(name, newAddr, newTel));
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다.");
	}

	private void displayAdd() {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("번호\t이름\t전화번호\t주소");
		System.out.println("-------------------------------------");

		Set<String> phoneKeySet = phoneBookMap.keySet();
		if (phoneKeySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			int num = 0;
			for (String name : phoneKeySet) {
				num++;
				Phone p = phoneBookMap.get(name);
				System.out.println(num + "\t" + p.getName() + "\t" + p.getAddr() + "\t" + p.getTel() + "\t");
			}
			System.out.println("-------------------------------------");
			System.out.println("출력 끝");
		}
	}

	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = sc.next();

		if (phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		System.out.print("전화번호 >> ");
		String tel = sc.next();
		System.out.print("주소 >> ");
		String addr = sc.next();

		phoneBookMap.put(name, new Phone(name, tel, addr));
	}

	private int displayMenu() {
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("* 1.전화번호 등록");
		System.out.println(" * 2.전화번호 수정");
		System.out.println(" * 3.전화번호 삭제");
		System.out.println(" * 4.전화번호 검색");
		System.out.println(" * 5.전화번호 전체  출력");
		System.out.println(" * 6.프로그램 종료 ");
		System.out.println("---------------------");
		System.out.print("입력하세요 >>");

		return sc.nextInt();
	}
}

class Phone {
	private String name;
	private String addr;
	private String tel;

	public Phone(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 주소=" + addr + ", 번호=" + tel;
	}
}
