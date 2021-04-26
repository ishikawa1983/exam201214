package exam210426;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] elems = line.split(" ");
		final String name1 = elems[0];
		final String name2 = elems[1];
		sc.close();

		int sum1 = getArraySum((name1 + name2).chars().map(c -> c - 'a' + 1).toArray());
		int sum2 = getArraySum((name2 + name1).chars().map(c -> c - 'a' + 1).toArray());
		System.out.println(sum1 > sum2 ? sum1 : sum2);
	}

	private static int getArraySum(int[] chars) {
		int[] retChars = new int[chars.length - 1];
		for (int i = 0; i < chars.length - 1; i++) {
			retChars[i] = chars[i] + chars[i + 1];
			retChars[i] = (retChars[i] > 101 ? retChars[i] - 101 : retChars[i]);
		}
		if (retChars.length == 1) {
			return retChars[0];
		} else {
			return getArraySum(retChars);
		}
	}
}
