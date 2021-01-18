import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] params = line.split(" ");
		final Integer rowNum = new Integer(params[0]);
		final Integer colNum = new Integer(params[1]);
		Integer[][] sugar = new Integer[rowNum][colNum];
		Integer[] sums = new Integer[rowNum];
		for (int i = 0; i < rowNum; i++) {
			sums[i] = 0;
			line = sc.nextLine();
			params = line.split(" ");
			for (int j = 0; j < colNum; j++) {
				sugar[i][j] = new Integer(params[j]);
				sums[i] += new Integer(params[j]);
			}
		}
		sc.close();

		Boolean succeed = true;
		String[] results = new String[rowNum];
		for (int i = 0; i < rowNum; i++) {
			results[i] = "";
			Integer sum = 0;
			Boolean isA = true;
			for (int j = 0; j < colNum; j++) {
				if (isA) {
					results[i] += "A";
				} else {
					results[i] += "B";
				}
				sum += sugar[i][j];
				if (isA) {
					if (sum * 2 == sums[i]) {
						isA = false;
					} else if (sum * 2 > sums[i]) {
						succeed = false;
						break;
					}
				}
			}
			if (isA) {
				succeed = false;
			}
			if (!succeed) {
				break;
			}
		}
		if (succeed) {
			System.out.println("Yes");
			for (int i = 0; i < rowNum; i++) {
				System.out.println(results[i]);
			}
		} else {
			System.out.println("No");
		}
	}
}
