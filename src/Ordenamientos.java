/*
 * A01363997 Jonatan Rodrigo Cabrera Berriel
 * Mergesort
 * 20/01/2018
 * --
 */

public class Ordenamientos {
	/*
	 * Parte hecha con genericos
	 */
	/*public static <E extends Comparable<E>> void bubbleSortGen(E[] valores) {
		for(int i = 0; i < valores.length - 1; i++) {
			for(int j = 0; j < valores.length -1 - i; j++) {
				if(valores[j].compareTo(valores[j+1]) > 0) {
					swap(j, j+1, valores);
				}
			}
		}
	}
	
	private static <E> void swap(int uno, int dos, E[] valores) {
		E tmp = valores[uno];
		valores[uno] = valores[dos];
		valores[dos] = tmp;
	}
	
	public static <E> void printArray(E[] array) {
		for(E a: array) {
			System.out.print(a + ",");
		}
		System.out.println("Done");
	}
	
	/*
	 * Parte hecha en clase
	 
	public static void bubbleSort(int[] values) {
		for(int i = 0; i < values.length - 1; i++) {
			for(int j = 0; j < values.length - 1 - i; j++) {
				if(values[j] > values[j + 1]) {
					swap(j, j + 1, values);
				}
			}
		}
	}
	
	private static void swap(int uno, int dos, int[] values) {
		int tmp = values[uno];
		values[uno] = values[dos];
		values[dos] = tmp;
	}
	*/
	public static void imprimeArreglo(int[] array) {
		for(int a:array) {
			System.out.print(a+",");
		}
		System.out.println("");
	}
	
	public static void mergesort(int[] datos) {
		mergesort(datos,0,datos.length -1);
	}
	
	private static void mergesort(int[] datos, int primero, int ultimo) {
		if(primero < ultimo) {
			int medio = (primero + ultimo)/2;
			mergesort(datos, primero, medio);
			mergesort(datos, medio + 1, ultimo);
			mezcla(datos, primero, ultimo);
		}
	}
	
	private static void mezcla(int[] datos, int primero, int ultimo) {
		int[] datosaux = new int[ultimo - primero+1];
		int medio = (primero + ultimo)/2;
		int index1 = primero;
		int index2 = medio+1;
		
		for(int i = 0; i < datosaux.length; i++) {
			if(index1 <= medio && index2 <= ultimo) {
				if(datos[index1] < datos[index2]) {
					datosaux[i] = datos[index1++];
				}
				else {
					datosaux[i] = datos[index2++];
				}
			}
			
			else if(index1 <= medio){
				datosaux[i] = datos[index1++];
			}
			else {
				datosaux[i] = datos[index2++];
			}
		}
		
		for(int j = 0; j<datosaux.length; j++) {
			datos[primero++] = datosaux[j];
		}
	}
	
	public static void main(String[] args) {
		/*Integer[] intArray = { 3, 1, 2, 5, 4 };
	    Double[] doubleArray = { 5.5, 2.3, 5.3, 1.4, 2.5 };
	    Character[] charArray = { 'H', 'O', 'L', 'A', 'M', 'U', 'N', 'D', 'O' };
	    String[] strArray = {"hola", "me", "llamo", "Jona", "mucho", "gusto"};
	    
		printArray(intArray);
		bubbleSortGen(intArray);
		printArray(intArray);
		
		printArray(doubleArray);
		bubbleSortGen(doubleArray);
		printArray(doubleArray);
		
		printArray(charArray);
		bubbleSortGen(charArray);
		printArray(charArray);
		
		printArray(strArray);
		bubbleSortGen(strArray);
		printArray(strArray);
		*/
		int[] prueba = {3,5,2,1,6,-1,15};
		imprimeArreglo(prueba);
		mergesort(prueba);
		imprimeArreglo(prueba);
	}

}
