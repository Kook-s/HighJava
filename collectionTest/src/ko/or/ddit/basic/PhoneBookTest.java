package ko.or.ddit.basic;

import java.text.Format;

import java.util.HashMap;
import java.util.Scanner;

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
public class PhoneBookTest {
	public static void main(String[] args) {
		HashMap<String, Phone1> map = new HashMap<>();
		int choice;
		String tel;
		String name;
		String addr;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("---------------------");
			System.out.println("1.전화번호 등록");
			System.out.println("2.전화번호 수정");
			System.out.println("3.전화번호 삭제");
			System.out.println("4.전화번호 검색");
			System.out.println("5.전화번호 전체출력");
			System.out.println("6.프로그램 종료");
			System.out.println("---------------------");
			System.out.print("입력하세요 >>");

			choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("정보를 입력하세요");
				System.out.print("이름을 입력하세요>>");
				name = sc.next();
				if (map.get(name) == null) {
					System.out.print("주소를 입력하세요>>");
					sc.nextLine();
					addr = sc.nextLine();
					System.out.print("번호를 입력하세요>>");
					tel = sc.next();
					map.put(name, new Phone1(name, addr, tel));
				} else {
					System.out.println("정보가 이미 있습니다");
				}
				break;
			case 2:
				System.out.print("수정할 이름을 입력하세요>>");
				name = sc.next();
				if (map.get(name) != null) {
					System.out.print("수정할 번호를 입력하세요>>");
					tel = sc.next();
					map.get(name).setTel(tel);
				} else {
					System.out.println("정보가 존재하지 않습니다.");
				}
				break;
			case 3:
				System.out.print("삭제 할 정보를 입력하세요>>");
				name = sc.next();
				map.remove(name);
				break;
			case 4:
				System.out.print("검색할 이름을 입력하세요>>");
				name = sc.next();
				if (map.get(name) != null) {
					System.out.println(map.get(name));
				} else {
					System.out.println("정보가 존재하지 않습니다.");
				}
				break;
			case 5:
				for (String key : map.keySet()) {
					Phone1 value = map.get(key);
					System.out.println(
							"이름 : " + value.getName() + " 주소 : " + value.getAddr() + "전화번호 : " + value.getTel());
				}
				break;
			case 6:

				return;

			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}
	}
}

class Phone1 {
	private String name;
	private String addr;
	private String tel;

	public Phone1(String name, String addr, String tel) {
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