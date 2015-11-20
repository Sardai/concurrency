import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = makeList(12);
		System.out.println(list);
		
		List<Integer> head = list.subList(0, list.size() / 2);
	    List<Integer> tail = list.subList(list.size()/2, list.size());
	    Sort headSort = new Sort(head);
	    Sort tailSort = new Sort(tail);
	    
	    
	    headSort.start();
	    tailSort.start();
	    
	    try{
	    	headSort.join(); tailSort.join();
	    	
	    	
	    	}
	    	catch (InterruptedException e){};
	    	 
	    System.out.println(head);
	    System.out.println(tail);
	    List<Integer> sorted = headSort.merge(head, tail);
	    System.out.println(sorted);

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

}
