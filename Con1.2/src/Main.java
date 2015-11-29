import java.util.ArrayList;
import java.util.Arrays;
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
	 * Split een lijst in twee lijsten om ze te sorteren via twee threads.
	 * @param randomList	Een ongesorteerde lijst meegegeven
	 */
	private static void splitAndSort(List<Integer> randomList){
		//Ongesorteerd
		List<Integer> list = new ArrayList<>(randomList);
		//Splitsen
		List<Integer> head = list.subList(0, list.size() / 2);
		List<Integer> tail = list.subList(list.size() / 2, list.size());
		//Object aanmaken van Sort
		Sort headSort = new Sort(head);
		Sort tailSort = new Sort(tail);
		//Thread starten
		headSort.start();
		tailSort.start();

		try {
			//zorgen dat ze beiden klaar zijn
			headSort.join();
			tailSort.join();
		} catch (InterruptedException e) {}
	}
	
	/**
	 * Methode om de tijd hoe lang het algoritme er over doet te meten.
	 * @param n		Aangeven hoe groot de lijst moet worden
	 */
	private static void test(int n){
		List<Integer> randomList = makeList(n);
		//Array maken om bij te houden hoe lang het uitvoeren van het sorteren doet
		long[] results = new long[10];
		for (int i = 0; i < 10; i++) {
			Long start = System.currentTimeMillis();
			
			splitAndSort(randomList);
			
			Long end = System.currentTimeMillis();
			results[i] = end-start;			
		}
		Arrays.sort(results);
		//Gemiddelde bereken
		long sum = 0;
		//negeer kortste en langste running time.
		for (int i = 1; i < results.length-1; i++) {
			sum += results[i];
		}
		long average = sum / 8;
		System.out.println(n+", "+average);
	}

	 
}