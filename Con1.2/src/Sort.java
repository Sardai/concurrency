import java.util.ArrayList;
import java.util.List;

public class Sort extends Thread {

	private List<Integer> list;

	public Sort(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		insertion(list);
		

	}

	public void insertion(List<Integer> list) {
		int i, j;
		for (i = 1; i < list.size(); i++) {
			int number = list.get(i);
			j = i;
			while ((j > 0) && (list.get(j - 1) > number)) {
				list.set(j, list.get(j - 1));
				j--;
			}
			list.set(j, number);
		}

	}
	
	public List<Integer> merge(List<Integer> head, List<Integer> tail){
		List<Integer> merged = new ArrayList<>();
		int counterHead = 0, counterTail = 0;
		while(counterHead < head.size()|| counterTail < tail.size()){
			int getalHead = Integer.MAX_VALUE, getalTail = Integer.MAX_VALUE;
				if(counterHead < head.size()){
					getalHead = head.get(counterHead);	
				}
				
				if(counterTail < tail.size()){
					getalTail = tail.get(counterTail);	
				}
				
			
			if(getalHead < getalTail){
				merged.add(getalHead);
				counterHead++;
			}else {
				merged.add(getalTail);
				counterTail++;
			}
			
			
			
		}
		return merged;
		
	}
	
	

}
