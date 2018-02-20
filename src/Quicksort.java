/*
 * Jonatan Rodrigo Cabrera Berriel A01363997
 * Quicksort
 * 28/01/18
 * --
 */

public class Quicksort {

	public static void quicksort(int[] arreglo) {
		quicksort(arreglo, 0, arreglo.length-1);
	}
	
	private static void quicksort(int[] arreglo, int min, int max) {
		if(min<max) {
			int posPivote = particionar(arreglo, min, max);
			quicksort(arreglo, min, posPivote-1);
			quicksort(arreglo, posPivote+1, max);
		}
	}
	
	private static int particionar(int[] arreglo, int min, int max) {
		int pivote = arreglo[min];
		int i = min + 1;
		for(int j = i; j <=max ; j++) {
			if(arreglo[j] < pivote) {
				swap(arreglo, i, j);
				i++;
			}
		}
		swap(arreglo, min, i-1);
		return i-1;
	}
	
	private static void swap(int[] arreglo, int origen, int destino) {
		int tmp = arreglo[origen];
		arreglo[origen] = arreglo[destino];
		arreglo[destino] = tmp;
	}
	
	public static void imprimeArreglo(int[] array) {
		for(int a:array) {
			System.out.print(a+",");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] arreglo = {5,3,10,4,7,8,2,9,1};
		//int[] arreglo1 = {6,2,9,7,5,1,3,4,1,1,1,10};
		imprimeArreglo(arreglo);
		quicksort(arreglo);
		imprimeArreglo(arreglo);
		//imprimeArreglo(arreglo1);
		//quicksort(arreglo1);
		//imprimeArreglo(arreglo1);
	}

}
