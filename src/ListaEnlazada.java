import java.util.NoSuchElementException;

public class ListaEnlazada<E> {
	private Nodo<E> inicio,
					fin;
	private int size;
	
	public ListaEnlazada(){
		this.inicio = this.fin = null;
		this.size = 0;
	}
	
	public ListaEnlazada(E[] datos) {
		//Tarea
		for(int i = datos.length-1; i<datos.length; i++) {
			this.insertarFin(datos[i]);
		}
	}
	
	//Que arrojen excepcion
	public E inicio() throws NoSuchElementException{
		try {
			return this.inicio.getDato();
		}
		catch(NullPointerException e) {
			throw new NoSuchElementException("No hay elementos");
		}
	}
	
	public E fin() {
		if(this.estaVacia()) {
			return null;
		}
		else {
			return this.fin.getDato();
		}
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean estaVacia() {
		return(this.size == 0);
	}
	
	public E getAt(int pos) {
		if(pos >= 0 && pos < this.size) {
			Nodo<E> current = this.inicio;
			for(int i = 0; i<pos; i++) {
				current = current.getNext();
			}
			return current.getDato();
		}
		else {
			throw new IllegalArgumentException("");
		}
	}
	
	public void insertarInicio(E dato) {
		Nodo<E> nodoTmp = new Nodo<E>(dato, this.inicio);
		this.inicio = nodoTmp;
		if(this.size == 0) {
			this.fin = nodoTmp;
		}
		this.size++;
	}
	
	public void insertarFin(E dato) {
		if(this.estaVacia()) {
			this.insertarInicio(dato);
		}
		else {
			Nodo <E> nodoTmp = new Nodo<E>(dato);
			this.fin.setNext(nodoTmp);
			this.fin = nodoTmp;
			this.size++;
		}
	}
	//IDe tarea
	public void insertarEn(int pos, E dato) {
		
	}
	
	public E borrarInicio() throws NoSuchElementException{
		try{
			E tmp = this.inicio();
			this.inicio = this.inicio.getNext();
			this.size--;
			if(this.size == 0) {
				this.fin = null;
			}
			return tmp;
		} catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el inicio de una lista vacía");
		}
	}
	
	public E borrarFin() throws NoSuchElementException{
		try {
			if(this.size == 1) {
				return this.borrarInicio();
			}else {
				E tmp = this.fin();
				Nodo<E> current = this.inicio;
				for(int i = 0; i<this.size-2; i ++) {
					current = current.getNext();
				}
				current.setNext(null);
				this.fin = current;
				this.size--;
				return tmp;
			}
		}
		catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el fin de una lista vacía");
		}
	}
	
	public void setAt(int pos, E dato) {
		if(pos>= 0 && pos<this.size) {
			Nodo <E> current =this.inicio;
			for(int i = 0; i  < pos;i++) {
				current.getNext();
			}
			current.setDato(dato);
		}
		else {
			throw new IllegalArgumentException("");
		}
	}
	
	public String toString() {
		Nodo<E> current = this.inicio;
		String resultado = "";
		for(int i = 0; i< this.size;i++) {
			resultado += current + ",";
			current = current.getNext();
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		ListaEnlazada<Integer> lista = new ListaEnlazada<>();
		lista.insertarInicio(20);
		lista.insertarInicio(10);
		lista.insertarInicio(5);
		System.out.println(lista);
		lista.setAt(1, 100);
		System.out.println(lista);
		lista.borrarFin();
		System.out.println(lista);
	}

}

class Nodo<E>{
	private E dato;
	private Nodo<E> next;
	
	public Nodo(E dato, Nodo<E> next) {
		this.dato = dato;
		this.next = next;
	}
	
	public Nodo(E dato) {
		this(dato, null);
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public Nodo<E> getNext() {
		return next;
	}

	public void setNext(Nodo<E> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return this.dato.toString();
	}
}
