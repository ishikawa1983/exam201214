package exam210301;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] params = line.split(" ");
		final Integer additionNum = new Integer(params[0]);
		final Integer subtractionNum = new Integer(params[1]);
		sc.close();

		final Integer limitNum = 99;

		Integer displayCount = 0;
		for (int i = 0; i <= limitNum; i++) {
			for (int j = 0; j <= limitNum; j++) {
				if (i + j <= limitNum) {
					System.out.println(i + " + " + j + " =");
					displayCount++;
					if (displayCount >= additionNum) {
						break;
					}
				}
			}
			if (displayCount >= additionNum) {
				break;
			}
		}

		displayCount = 0;
		for (int i = limitNum; i >= 0; i--) {
			for (int j = 0; j <= limitNum; j++) {
				if (i - j >= 0) {
					System.out.println(i + " - " + j + " =");
					displayCount++;
					if (displayCount >= subtractionNum) {
						break;
					}
				}
			}
			if (displayCount >= subtractionNum) {
				break;
			}
		}
	}
}
