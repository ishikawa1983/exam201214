package exam210125;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		final Integer coinNum = new Integer(line);
		final String coinRow = sc.nextLine();
		sc.close();

		String[] coinArray = coinRow.split("");
		CoinState[] coinStatus = new CoinState[coinNum];
		for (int i = 0; i < coinNum; i++) {
			coinStatus[i] = new CoinState(coinArray[i]);
		}
		while (true) {
			for (int i = 1; i < coinNum - 1; i++) {
				Boolean left = false;
				Boolean right = false;
				for (int j = 0; j < i; j++) {
					if (!coinStatus[i].isWhite.equals(coinStatus[j].isWhite)) {
						left = true;
						break;
					}
				}
				for (int j = i + 1; j < coinNum; j++) {
					if (!coinStatus[i].isWhite.equals(coinStatus[j].isWhite)) {
						right = true;
						break;
					}
				}
				if (left && right) {
					coinStatus[i].toReverse = true;
				}
			}
			Boolean reversed = false;
			for (int i = 1; i < coinNum - 1; i++) {
				if (coinStatus[i].toReverse) {
					coinStatus[i].isWhite = !coinStatus[i].isWhite;
					coinStatus[i].toReverse = false;
					reversed = true;
				}
			}
			if (!reversed) {
				break;
			}
		}

		Integer blackNum = 0;
		for (int i = 0; i < coinNum; i++) {
			if (!coinStatus[i].isWhite) {
				blackNum++;
			}
		}
		System.out.println(blackNum);
	}

	private static class CoinState {
		public CoinState(String color) {
			this.isWhite = "w".equals(color);
			this.toReverse = false;
		}
		public Boolean isWhite;
		public Boolean toReverse;
	}
}
