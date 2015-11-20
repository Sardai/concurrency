
public class Sort {

	
	public int[] sortInsertion(int[] list) {
		int key;
		int j;
		for(int i = 1; i < list.length; i++){
			key = list[i];
			for(j = i - 1; (j >= 0) &&(list[j] < key); j--){
				list[j + 1] = list[j];		
			}
			
			list[j + 1] = key;
			
		}
		
		return list;

	}

	/**
	 * Lijst generegen om te sorteren
	 * 
	 * @param aantalGetallen
	 * @return Een lijst
	 */
	public int[] makeList(int aantalGetallen) {
		int[] list = new int[aantalGetallen];
		for (int i = 0; i < aantalGetallen; i++) {
			int getal = (int) (Math.random() * 10);
			list[i] = getal;

		}

		return list;
	}
	
	
}
