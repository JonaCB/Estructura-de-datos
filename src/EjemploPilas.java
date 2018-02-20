/*
 * Jonatan Rodrigo Cabrera Berriel
 * A01363997
 * EjemploPilas
 * 12/02/2018
 * Comentarios: --
 */
public class EjemploPilas {
	
	public EjemploPilas(){}
	
	public void borrarValor(StackLE<Integer> pila, Integer dato) {
		StackLE<Integer> pilatmp = new StackLE<Integer>();
		while(!pila.isEmpty()) {
			if(pila.top().compareTo(dato)==0) {
				pila.pop();
			}
			else {
				pilatmp.push(pila.pop());
			}
		}
		
		while(!pilatmp.isEmpty()) {
			pila.push(pilatmp.pop());
		}
	}
	
	public StackLE<Integer> clonarPila(StackLE<Integer> pila){
		StackLE<Integer> pilatmp = new StackLE<Integer>();
		StackLE<Integer> newPila = new StackLE<Integer>();
		
		while(!pila.isEmpty()) {
			pilatmp.push(pila.pop());
		}
		
		while(!pilatmp.isEmpty()) {
			pila.push(pilatmp.top());
			newPila.push(pilatmp.pop());
		}
		
		return newPila;
	}
	
	public static void main(String[] args) {
		StackLE<Integer> prueba = new StackLE<Integer>();
		
		EjemploPilas ej = new EjemploPilas();
		
		prueba.push(1);
		prueba.push(2);
		prueba.push(2);
		prueba.push(2);
		prueba.push(3);
		prueba.push(4);
		prueba.push(3);
		
		System.out.println(prueba);
		
		ej.borrarValor(prueba, 2);
		
		System.out.println(prueba);
		
		System.out.println(ej.clonarPila(prueba));
	}
}
