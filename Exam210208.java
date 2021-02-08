package exam210208;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] params = line.split(" ");
		final Integer n = new Integer(params[0]);
		final Integer m = new Integer(params[1]);
		sc.close();

		// バインダーの各ファイルのどの位置か（0～2n-1までの値）
		int index = (m - 1) % (n * 2);
		// 裏側の名刺の位置
		int backSideIndex = n * 2 - index;
		// 当該ファイル直前の名刺番号
		int offset = m - index - 1;

		System.out.println(offset + backSideIndex);
	}
}
