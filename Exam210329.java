package exam210329;

import java.util.*;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] elems = line.split(" ");
		final Integer bCount = new Integer(elems[0]);
		final Integer qCount = new Integer(elems[1]);
		List<Bread> breads = new ArrayList<>();
		for (int i = 0; i < bCount; i++) {
			line = sc.nextLine();
			elems = line.split(" ");
			breads.add(new Bread(new Integer(elems[0]), new Integer(elems[1])));
		}
		List<Queue> queues = new ArrayList<>();
		for (int i = 0; i < qCount; i++) {
			line = sc.nextLine();
			elems = line.split(" ");
			String type = elems[0];
			List<Integer> bbNums = new ArrayList<>();
			for (int j = 1; j <= bCount; j++) {
				bbNums.add(new Integer(elems[j]));
			}
			queues.add(new Queue(type, bbNums));
		}
		sc.close();

		for (Queue queue : queues) {
			switch(queue.type) {
			case "buy":
				if (Stream.iterate(0, x -> x + 1).limit(bCount).allMatch(i -> breads.get(i).num >= queue.bbNums.get(i))) {
					for (int i = 0; i < bCount; i++) {
						breads.get(i).num -= queue.bbNums.get(i);
					}
					Integer total = Stream.iterate(0, x -> x + 1).limit(bCount).mapToInt(i -> breads.get(i).price * queue.bbNums.get(i)).sum();
					System.out.println(total.toString());
				} else {
					System.out.println("-1");
				}
				break;
			case "bake":
				for (int i = 0; i < bCount; i++) {
					breads.get(i).num += queue.bbNums.get(i);
				}
				break;
			default:
				break;
			}
		}
	}

	public static class Bread {
		public Integer price = 0;
		public Integer num = 0;

		public Bread(Integer price, Integer num) {
			this.price = price;
			this.num = num;
		};
	}

	public static class Queue {
		public String type = "";
		public List<Integer> bbNums;

		public Queue(String type, List<Integer> bbNums) {
			this.type = type;
			this.bbNums = bbNums;
		};
	}
}
