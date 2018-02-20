
public class Pruebas {

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
		int[] datosaux = new int[ultimo - primero];
		int medio = (primero + ultimo)/2;
		int in1 = primero;
		int in2 = medio + 1;
		int i = 0;
		
		while(in1 != medio || in2 != ultimo) {
			if(datos[in1] < datos[in2]) {
				datosaux[i++] = datos[in1++];
			}
			else {
				datosaux[i++] = datos[in2++]; 
			}
		}
		
		if(in1 == medio) {
			while(i < datosaux.length - 1) {
				datosaux[i++] = datos[in2++];
			}
		}
		else {
			while(i < datosaux.length - 1) {
				datosaux[i++] = datos[in2++];
			}
		}
		
		for(int j = 0; j < datosaux.length -1; j++) {
			datos[j] = datosaux[j];
		}
	}
	
	public static void imprimeArreglo(int[] array) {
		for(int a:array) {
			System.out.print(a+",");
		}
		System.out.println("");
	}
		
	public static void main(String[] args) {
		int[] datos = {3,5, 1, 2};
		imprimeArreglo(datos);
		mergesort(datos);
		imprimeArreglo(datos);
	}

}
