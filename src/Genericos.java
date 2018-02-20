/*
 * Bubble sort
 * Quicksort
 * Mergesort
 * Binary search
 */
public class Genericos {

	/*public static <E> void bubbleSort() {
		
	}*/
	
	public static <E extends Comparable<E>> void quicksort(E[] array){
		quicksort(array, 0, array.length -1);
	}
	
	private static <E extends Comparable<E>> void quicksort(E[] array, int min, int max) {
		if(min < max) {
			int posPivote = particionarGen(array, min, max);
			quicksort(array, min, posPivote-1);
			quicksort(array, posPivote +1, max);
		}
	}
	
	private static <E extends Comparable<E>> int particionarGen(E[] array, int min, int max) {
		E pivote = array[min];
		int i = min+1;
		for(int j = i;  j <= max; j++) {
			if(array[j].compareTo(pivote) < 0){
				swap(array, i++, j);
				i++;
			}
		}
		swap(array, min, i-1);
		return i - 1;
	}
	
	private static <E> void swap(E[] array, int from, int to) {
		E tmp = array[from];
		array[from] = array[to];
		array[to] = tmp;
	}
	
	private static <E> void printArray(E[] array) {
		for(E a: array) {
			System.out.print(a + ",");
		}
		System.out.println("Done");
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {5,3,10,4,7,8,2,9,1};
		Double[] doubleArray = { 5.5, 2.3, 5.3, 1.4, 2.5, 3.5 };
	    Character[] charArray = { 'H', 'O', 'L', 'A', 'M', 'U', 'N', 'D', 'O' };
	    String[] strArray = {"hola", "me", "llamo", "Jona", "mucho", "gusto"};
	
	    printArray(intArray);
		quicksort(intArray);
		printArray(intArray);
		
		printArray(doubleArray);
		quicksort(doubleArray);
		printArray(doubleArray);
		
		printArray(charArray);
		quicksort(charArray);
		printArray(charArray);
		
		printArray(strArray);
		quicksort(strArray);
		printArray(strArray);
	}

}
