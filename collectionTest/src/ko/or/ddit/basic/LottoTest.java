package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		new LottoTest().lottoStart();
	}

	public void lottoStart() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				buyLotto();
				break;

			case 2:
				System.out.println("\n감사합니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다.");
				System.out.println("1 또는 2를 입력하세요.");
				break;
			}
		}
	}

	public int displayMenu() {
		System.out.println("\n==========================");
		System.out.println("      Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println(" 1. Lotto 구입");
		System.out.println(" 2. 프로그램 종료");
		System.out.println("==========================	");
		System.out.print("메뉴선택 : ");

		return scan.nextInt();
	}

	public void buyLotto() {
		System.out.println("");
		System.out.println("Lotto 구입 시작");
		System.out.println("");
		System.out.println("1000원에 로또번호 하나 입니다.");
		System.out.print("금액 입력 : ");

		int money = scan.nextInt();

		if (money < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		} else if (money >= 101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			return;
		}
		HashSet<Integer> lottoSet = new HashSet<>();
		Random rnd = new Random();
		int count = money / 1000;

		for (int i = 1; i <= count; i++) {
			while (lottoSet.size() < 6) {
				lottoSet.add(rnd.nextInt(45) + 1);
			}
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
			Collections.sort(lottoList);
			System.out.print("로또번호" + i + " : ");
			for (int j = 0; j < lottoList.size(); j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(lottoList.get(j));
			}
			System.out.println();
			lottoSet.clear();
		}
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money % 1000) + "원 입니다.");

	}
}
