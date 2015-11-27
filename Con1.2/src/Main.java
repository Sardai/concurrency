import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		 test(25000);
		 test(50000);
		 test(100000);
		 test(200000);
		 test(400000);
		 test(800000);
	}

	/**
	 * Lijst generegen om te sorteren
	 * 
	 * @param aantalGetallen
	 * @return Een lijst
	 */
	public static ArrayList<Integer> makeList(int aantalGetallen) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < aantalGetallen; i++) {
			int getal = (int) (Math.random() * 10);
			list.add(i, getal);

		}

		return list;
	}

	private static void test(int n) {
		System.out.println(n + " getallen");
		List<Integer> randomList = makeList(n);

		for (int i = 0; i < 10; i++) {
			Long start = System.currentTimeMillis();
			
			List<Integer> list = new ArrayList<>(randomList);			
			List<Integer> head = list.subList(0, list.size() / 2);
			List<Integer> tail = list.subList(list.size() / 2, list.size());
			Sort headSort = new Sort(head);
			Sort tailSort = new Sort(tail);

			headSort.start();
			tailSort.start();

			try {
				headSort.join();
				tailSort.join();
			} catch (InterruptedException e) {}

			Long end = System.currentTimeMillis();

			System.out.println("Poging:" + (i + 1) + " " + (end - start));
		}
	}
}