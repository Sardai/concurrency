package opdr1_2;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse die door middel van een Thread gaat sorteren
 * @author Rick, Chris
 *
 */
public class Sort extends Thread {

	private List<Integer> list;

	//Constructor
	public Sort(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		insertion(list);
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
		//Blijven lopen totdat beiden counters overeenkomen
		while(indexFirst < first.size()|| indexSecond < second.size()){
			int getalFirst = Integer.MAX_VALUE, getalSecond = Integer.MAX_VALUE;
				//Kijken of de first lijst nog niet klaar is
				if(indexFirst < first.size()){
					getalFirst = first.get(indexFirst);	
				}
				//Kijken of de second lijst nog niet klaar is
				if(indexSecond < second.size()){
					getalSecond = second.get(indexSecond);	
				}
				
			//Kijken welke kleiner is
			//En de kleinste toevoegen aan de lijst
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