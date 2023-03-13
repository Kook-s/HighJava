package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	HashMap<Integer, Room> roomMap;
	Scanner sc;

	public HotelTest() {
		roomMap = new HashMap<>();
		sc = new Scanner(System.in);
		roomInfo();
	}

	private void roomInfo() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == 0) {
					roomMap.put((i + 2) * 100 + (j + 1), new Room((i + 2) * 100 + (j + 1), "싱글룸", "-"));
				} else if (i == 1) {
					roomMap.put((i + 2) * 100 + (j + 1), new Room((i + 2) * 100 + (j + 1), "더블룸", "-"));
				} else {
					roomMap.put((i + 2) * 100 + (j + 1), new Room((i + 2) * 100 + (j + 1), "스위트룸", "-"));
				}
			}
		}
	}

	public static void main(String[] args) {

		new HotelTest().roomStart();

	}

	public void roomStart() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");

		while (true) {

			switch (displayMenu()) {
			case 1:
				insert();
				break;

			case 2:
				delete();
				break;

			case 3:
				displayAdd();
				break;
			case 4:
				System.out.println(" 프로그램을 종료합니다.");
				return;

			default:
				System.out.println("번호를 잘못 입력했습니다.");
				break;
			}
		}
	}

	private void displayAdd() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		Set<Integer> roomSet = roomMap.keySet();
		ArrayList<Integer> roomList = new ArrayList<>(roomSet);
		Collections.sort(roomList);

		for (int num : roomList) {
			System.out.println(roomMap.get(num));
		}

		System.out.println("----------------------------------------------");
	}

	private void delete() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력>>");

		int roomNum = sc.nextInt();
		if (roomMap.get(roomNum) == null) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			return;
		} else if (roomMap.get(roomNum).getName().equals("-")) {
			System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		System.out.println(roomNum + "객실의" + roomMap.get(roomNum).getName() + "님 체크아웃을 완료하였습니다.");
		roomMap.get(roomNum).setName("-");

	}

	private void insert() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int roomNum = sc.nextInt();
		if (roomMap.get(roomNum) == null) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니다?");
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		roomMap.get(roomNum).setName(name);
		System.out.println("체크인이 완료되었습니다.");

	}

	private int displayMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>>");
		return sc.nextInt();
	}
}

class Room {
	private int roomNum;
	private String roomKind;
	private String name;

	public Room(int roomNum, String roomKind, String name) {
		super();
		this.roomNum = roomNum;
		this.roomKind = roomKind;
		this.name = name;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomKind() {
		return roomKind;
	}

	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return roomNum + "  " + roomKind + "  " + name;
	}

}