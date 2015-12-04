package opdr1_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static final int MAX_SIZE = 10000;
	
	public static void main(String[] args) {
		System.out.print(MAX_SIZE+", ");
		 test(25000);
		 test(50000);
		 test(100000);
		 test(200000);
		 test(400000);
		 test(800000);
		 System.out.println();
			System.out.println("done");
	}

	/**
	 * Vult een lijst met random getallen
	 * @param aantalGetallen	Hoe groot de lijst moet worden
	 * @return de lijst
	 */
	public static ArrayList<Integer> makeList(int aantalGetallen) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < aantalGetallen; i++) {
			int getal = (int) (Math.random() * 10);
			list.add(i, getal);

		}

		return list;
	}
	/**
	 * Methode om de tijd hoe lang het algoritme er over doet te meten.
	 * @param n		Aangeven hoe groot de lijst moet worden
	 */
	private static void test(int n) {
		//System.out.println(n + " getallen");
		List<Integer> randomList = makeList(n);
		long[] results = new long[10];
		for (int i = 0; i < 10; i++) {
			Long start = System.currentTimeMillis();
			
			List<Integer> list = new ArrayList<>(randomList);			
			Sort sort = new Sort(list,MAX_SIZE); 
			sort.run();
			
			Long end = System.currentTimeMillis();
			results[i] = end-start;
		}
		Arrays.sort(results);
		long sum = 0;
		//negeer kortste en langste running time.
		for (int i = 1; i < results.length-1; i++) {
			sum += results[i];
		}
		long average = sum / 8;
		System.out.print(average+", ");
	}

}
