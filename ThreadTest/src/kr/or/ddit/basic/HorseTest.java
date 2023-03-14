package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Random;

public class HorseTest {
	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] { new Horse("01번말"), new Horse("02번말"), new Horse("03번말"), new Horse("04번말"),
				new Horse("05번말"), new Horse("06번말"), new Horse("07번말"), new Horse("08번말"), new Horse("09번말"),
				new Horse("10번말") };

		GameState gs = new GameState(horseArr);

		for (Horse h : horseArr) {
			h.start();
		}
		gs.start();

		for (Horse h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		Arrays.sort(horseArr);

		for (Horse h : horseArr) {
			System.out.println(h);
		}

	}
}

class Horse extends Thread implements Comparable<Horse> {
	public static int currenRank = 0; // 말등수를 구할 때
	private String horseName;
	private int rank;
	private int location;

	public Horse(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + "는(은)" + rank + "등 입니다.";
	}

	@Override
	public int compareTo(Horse horse) {
		// TODO Auto-generated method stub
		return Integer.compare(this.rank, horse.getRank());
	}

	@Override
	public synchronized void run() {
		Random rnd = new Random();
		for (int i = 1; i <= 50; i++) {
			this.location = i;
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		// 한 마리의 말의 경주가 끝나면 현재의 등수를 구해서 저장한다.
		currenRank++;
		this.rank = currenRank;
	}

}

class GameState extends Thread {
	private Horse[] horseArr; // 경주에 참가한 말들이 정보가 저정될 배열 변수 선언

	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}

	@Override
	public void run() {

		while (true) {
			if (Horse.currenRank == horseArr.length)
				break;

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("=============================================================");
			for (int i = 0; i < horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName() + " : ");
				for (int j = 1; j <= 50; j++) {
					if (horseArr[i].getLocation() == j) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			System.out.println("=============================================================");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

	}

}
