/*
 * Implementar binary search con genéricos
 * Binary search recursiva con genericos (fn de prep y fn recursiva)
 */

public class BinarySearch {

	public static int binarySearch(int value, int[] values) {
		int min = 0,
			max = values.length - 1,
			avg;
		
		while(min <= max) {
			avg = (max + min)/2;
			if(values[avg] == value) {
				return avg;
			}
			else if(value < values[avg]) {
				max = avg - 1;
				avg = (min + max)/2;
			}
			else {
				min = avg + 1;
				avg = (min + max)/2;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,20,25,50,51,60,62, 400,550};
		
		System.out.println(binarySearch(3, nums));
	}

}
