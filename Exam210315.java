package exam210315;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		final Integer wordNum = new Integer(line);
		for (int i = 0; i < wordNum; i++) {
			line = sc.nextLine();
			System.out.println(pluralize(line));
		}
		sc.close();
	}

	private static String pluralize(String word) {
		if (word.endsWith("s") ||
			word.endsWith("sh") ||
			word.endsWith("ch") ||
			word.endsWith("o") ||
			word.endsWith("x")) {
			return word + "es";
		} else if (word.endsWith("f") || word.endsWith("fe")) {
			return word.replaceAll("fe?$", "ves");
		} else if (word.matches(".*[^aiueo]y")) {
			return word.replaceAll("y$", "ies");
		} else {
			return word + "s";
		}
	}
}
