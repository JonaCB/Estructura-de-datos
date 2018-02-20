import java.util.NoSuchElementException;

public class StackLE <E>{
private ListaEnlazada<E> lista;
	
	public StackLE() {
		this.lista = new ListaEnlazada<>();
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void push(E dato) {
		this.lista.insertarInicio(dato);; //2
	}
	
	public E pop() throws NoSuchElementException{
		//return this.lista.borrarFin(); //1
		//Mucho más eficiente pues el borrado es de orden N o de orden constante
		try {
			return this.lista.borrarInicio();//2
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un pop de un Stack vacío");
		}
	}
	
	public E top() throws NoSuchElementException{
		try {
			return this.lista.inicio();	
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un top de un Stack vacío");
		}
	}
	
	public void flush() {
		this.lista = new ListaEnlazada<>();
		System.gc();
	}
	
	public String toString() {
		return this.lista.toString();
	}
	
	public static void main(String[] args) {
		StackLE<String> pila1 = new StackLE<String>();
		
		String[] nombres = {"Hector", "Elías", "Kevin", "Eutimio", "Quirino", "Donovan", "Arturo"};
		for(String nombre:nombres) {
			pila1.push(nombre);
		}
		
		System.out.println(pila1);
		
		while(!pila1.isEmpty()) {
			System.out.println(pila1.pop());
		}
		
	}
}
