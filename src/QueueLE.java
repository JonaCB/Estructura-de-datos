import java.util.NoSuchElementException;

public class QueueLE<E> {
	private ListaEnlazada<E> lista;
	
	public QueueLE() {
		this.lista = new ListaEnlazada<>();
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void enqueue(E dato) {
		//this.lista.insertarInicio(dato);//1
		
		this.lista.insertarFin(dato); //2
	}
	
	public E dequeue() throws NoSuchElementException{
		//return this.lista.borrarFin(); //1
		//Mucho más eficiente pues el borrado es de orden N o de orden constante
		try {
			return this.lista.borrarInicio();//2
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una fila vacía");
		}
	}
	
	public void flush() {
		this.lista = new ListaEnlazada<>();
		System.gc();
	}
	
	public E next() throws NoSuchElementException{
		try {
			return this.lista.inicio();	
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un next de una fila vacía");
		}
	}
	
	public String toString() {
		return this.lista.toString();
	}
	
	public static void main(String[] args) {
		QueueLE<String> fila1 = new QueueLE<String>();
		String[] nombres = {"Hector", "Elías", "Kevin", "Eutimio", "Quirino", "Donovan", "Arturo"};
		for(String nombre:nombres) {
			fila1.enqueue(nombre);
		}
		
		while(!fila1.isEmpty()) {
			System.out.println(fila1.dequeue());
		}
		
	}

}
