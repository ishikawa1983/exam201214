package exam201214;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		final Integer year = 2000;
		final Integer month = 1;
		final Integer date = 1;
		final LocalDateTime limitTime = LocalDateTime.of(year, month, date, 8, 59);
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] params = line.split(" ");
		final Integer a = new Integer(params[0]);
		final Integer b = new Integer(params[1]);
		final Integer c = new Integer(params[2]);
		line = sc.nextLine();
		final Integer num = new Integer(line);
		LocalDateTime[] paramTimes = new LocalDateTime[num];
		for (int i = 0; i < num; i++) {
			line = sc.nextLine();
			params = line.split(" ");
			Integer hour = new Integer(params[0]);
			Integer minutes = new Integer(params[1]);
			paramTimes[i] = LocalDateTime.of(year, month, date, hour, minutes);
		}
		sc.close();

		for (int i = num - 1; i >= 0; i--) {
			if (!paramTimes[i].plusMinutes(b + c).isAfter(limitTime)) {
				LocalDateTime resultTime = paramTimes[i].minusMinutes(a);
				String hour = String.format("%02d", resultTime.getHour());
				String minuite = String.format("%02d", resultTime.getMinute());
				System.out.println(hour + ":" + minuite);
				break;
			}
		}
	}
}
