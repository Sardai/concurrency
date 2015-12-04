package opdr1_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Deze class gaat lijsten sorteren
 * @author Chris, Rick
 *
 */
public class Sort {
	/**
	 * Sorteert een lijst dmv insertie.
	 * @param unsorted  Ongesorteerde lijst
	 * @return de gesorteerde lijst
	 */
	public List<Integer> insertion(List<Integer> unsorted){
		int i,j;
		List<Integer> list = new ArrayList<>(unsorted);
	    for (i = 1; i < list.size(); i++) {
	    	int number = list.get(i);
	        j = i;
	        while((j > 0) && (list.get(j - 1) > number)) {
	        	list.set(j,list.get(j - 1));
	            j--;
	        }
	        list.set(j,number);
	    }
	    return list;
	}
	
	/**
	 * Vult een lijst met random getallen
	 * @param amount	Hoe groot de lijst moet worden
	 * @return de lijst
	 */
	public List<Integer> generateList(int amount){
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < amount; i++) {
			list.add(r.nextInt(10));
		}
		return list;
	}
	
	
}
