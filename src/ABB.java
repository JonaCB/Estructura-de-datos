import java.util.NoSuchElementException;

public class ABB<E extends Comparable<E>> {
	private NodoABB<E> raiz;
	private int size;
	
	
	public ABB() {
		this.raiz = null;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void insertar(E dato) {
		NodoABB<E> nvo = new NodoABB<E>(dato);
		this.size++;
		if(this.raiz == null) {
			this.raiz = nvo;
		}
		else {
			NodoABB<E> parent,current;
			current = parent = this.raiz;
			while(current!=null) {
				parent = current;
				if(dato.compareTo(current.getValor())>0) {
					current = current.getDer();
					if(current == null) {
						parent.setDer(nvo);
					}
				}
				else {
					current = current.getIzq();
					if(current == null) {
						parent.setIzq(nvo);
					}
				}
			}
		}
	}
	
	public E buscar(E dato) {
		NodoABB<E> tmp = this.raiz;
		while(tmp != null) {
			if(dato.equals(tmp.getValor())) {
				return tmp.getValor();
			}
			else if(dato.compareTo(tmp.getValor())<0) {
				tmp = tmp.getIzq();
			}
			else {
				tmp = tmp.getDer();
			}
		}
		return null;
	}
	
	public E eliminar(E dato) {
		NodoABB<E> current = this.raiz,
					parent=this.raiz;
		
		while(current!=null && current.getValor().equals(dato)) {
			parent = current;
			current = dato.compareTo(current.getValor())<0 ? current.getIzq():current.getDer();
		}
		//current es igual a null o current está en el nodo a borrar y parent en el anterior
		if(current == null) {
			throw new NoSuchElementException("No se encontró "+dato+" en el árbol");
		}
		//Aquí sí está current en el nodo a borrar y parent en el anterior
		if(current.getIzq() == null && current.getDer() == null) {
			//Caso borrar un nodo hoja
			if(parent.getIzq()==current) {
				parent.setIzq(null);
			}
			else {
				parent.setDer(null);
			}
		//Casos borrar con 1 hijo
		}else if(current.getIzq() == null ) {
			if(parent.getIzq()==current) {
				parent.setIzq(current.getDer());
			}
			else {
				parent.setDer(current.getDer());
			}
		}else if(current.getDer() == null) {
			if(parent.getIzq()==current) {
				parent.setIzq(current.getIzq());
			}
			else {
				parent.setDer(current.getIzq());
			}
		}		
		//Caso borrar con 2 hijos usando la técnica del predecesor
	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo){
		NodoABB<E> current = nodo.getIzq();
		while(current.getDer()!=null) {
			current = current.getDer();
		}
		
		return current;
	}
	
	public static void main(String[] args) {
		ABB<Integer> a = new ABB<Integer>();
		a.insertar(50);
		a.insertar(25);
		a.insertar(60);
		a.insertar(10);
		a.insertar(40);
		a.insertar(55);
		a.insertar(80);
		a.insertar(30);
		System.out.println(a.buscar(30));
		a.eliminar(30);
		//System.out.println();
	}
}

class NodoABB<E>{
	private E valor;
	private NodoABB<E> izq, 
					   der;
	
	public NodoABB(E valor) {
		this(valor, null, null);
	}

	public NodoABB(E valor, NodoABB<E> izq, NodoABB<E> der) {
		this.valor = valor;
		this.izq = izq;
		this.der = der;
	}
	
	public E getValor() {
		return this.valor;
	}
	
	public void setValor(E valor) {
		this.valor = valor;
	}
	
	public NodoABB<E> getIzq(){
		return this.izq;
	}
	
	public void setIzq(NodoABB<E> izq) {
		this.izq = izq;
	}
	
	public NodoABB<E> getDer(){
		return this.der;
	}
	
	public void setDer(NodoABB<E> der) {
		this.der = der;
	}
	
	public String toString() {
		return this.valor.toString();
	}
}
