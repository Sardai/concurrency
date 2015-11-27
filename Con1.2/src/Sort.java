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
	
	public static List<Integer> merge(List<Integer> first, List<Integer> second){
		List<Integer> merged = new ArrayList<>();
		int counterFirst = 0, counterSecond = 0;
		while(counterFirst < first.size()|| counterSecond < second.size()){
			int getalFirst = Integer.MAX_VALUE, getalTail = Integer.MAX_VALUE;
				if(counterFirst < first.size()){
					getalFirst = first.get(counterFirst);	
				}
				
				if(counterSecond < second.size()){
					getalTail = second.get(counterSecond);	
				}
				
			
			if(getalFirst < getalTail){
				merged.add(getalFirst);
				counterFirst++;
			}else {
				merged.add(getalTail);
				counterSecond++;
			}
			
			
			
		}
		return merged;
		
	}
	
	

}