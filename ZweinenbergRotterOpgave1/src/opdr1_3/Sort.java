package opdr1_3;
import java.util.ArrayList;
import java.util.List;

public class Sort extends Thread {

	private List<Integer> randomList;
	public List<Integer> mergedList;
	private int maxSize;
	
	/**
	 * @param list de ongesorteerde lijst
	 * @param maxSize de drempelwaarde voor de grote van de lijst.
	 */
	public Sort(List<Integer> list,int maxSize) {
		this.randomList = list;
		this.maxSize = maxSize;
	}

	/**
	 * Methode van de Thread
	 * Wordt aangeroepen met start()
	 */
	@Override
	public void run() {
		
		if(randomList.size() > maxSize){	
			List<Integer> head = randomList.subList(0, randomList.size() / 2);
			List<Integer> tail = randomList.subList(randomList.size() / 2, randomList.size());
			
			Sort headSort = new Sort(head,maxSize);
			Sort tailSort = new Sort(tail,maxSize);
			headSort.start();
			tailSort.start();

			try {
				headSort.join();
				tailSort.join();
				mergedList = Sort.merge(headSort.mergedList, tailSort.mergedList);
			} catch (InterruptedException e) {}
			
			return;
		}
		mergedList = new ArrayList<>(randomList);		
		insertion(mergedList);	
	}
	/**
	 * Sorteren van de lijst dmv insertie
	 * @param list	Gesorteerde lijst
	 */
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
	/**
	 * Samenvoegen van de gesorteerde lijsten dmv merge
	 * @param first		Gesorteerde lijst 
	 * @param second	Gesorteerde lijst
	 * @return			Samen gevoegde lijst en gesorteerd
	 */
	public static List<Integer> merge(List<Integer> first, List<Integer> second){
		List<Integer> merged = new ArrayList<>();
		int indexFirst = 0, indexSecond = 0;
		//Zorgen dat beide lijsten doorlopen worden
		while(indexFirst < first.size()|| indexSecond < second.size()){			
			int getalFirst = Integer.MAX_VALUE, getalSecond = Integer.MAX_VALUE;
				if(indexFirst < first.size()){
					getalFirst = first.get(indexFirst);	
				}
				
				if(indexSecond < second.size()){
					getalSecond = second.get(indexSecond);	
				}
			//Kijken welke van de twee waarden uit de lijsten kleiner is
			if(getalFirst < getalSecond){
				merged.add(getalFirst);
				indexFirst++;
			}else {
				merged.add(getalSecond);
				indexSecond++;
			}
		}
		return merged;		
	}
	
	
	

}
