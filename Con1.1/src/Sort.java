import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort {

	
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
	
	public List<Integer> generateList(int amount){
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < amount; i++) {
			list.add(r.nextInt(10));
		}
		return list;
	}
	
	
}
