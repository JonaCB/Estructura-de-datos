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
		if(dato.equals(this.raiz.getValor())) {
			if(this.raiz.getDer() == null && this.raiz.getIzq() == null) {
				this.raiz = null;
			}
			else if(this.raiz.getIzq() == null) {
				this.raiz = this.raiz.getDer();
			}
			else if(this.raiz.getDer() == null) {
				this.raiz = this.raiz.getIzq();
			}
			else{
				NodoABB<E> predecesor = predecesor(this.raiz);
				E datoPredecesor = predecesor.getValor();
				eliminar(datoPredecesor);
				this.size++;
				this.raiz.setValor(datoPredecesor);
			}
			this.size--;
			return this.raiz.getValor();
		}
		else {
			NodoABB<E> current = this.raiz,
						parent=this.raiz;
			
			while(current!=null && !current.getValor().equals(dato)) {
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
			else {
				NodoABB<E> tmp = predecesor(current);
				if(tmp.getIzq()!=null) {
					current.getIzq().setDer(tmp.getIzq());
				}
				
				if(parent.getIzq()==current) {
					parent.setIzq(tmp);
					tmp.setDer(current.getDer());
				}
				else{
					parent.setDer(tmp);
					tmp.setDer(current.getDer());
				}
			}
			this.size--;
			return current.getValor();
		}
	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo){
		NodoABB<E> current = nodo.getIzq();
		while(current.getDer()!=null) {
			current = current.getDer();
		}
		
		return current;
	}
	
	public void preorden() {
		this.preorden(this.raiz);
		System.out.println();
	}
	
	private void preorden(NodoABB<E> nodo) {
		if(nodo!=null) {
			System.out.print(nodo+",");
			this.preorden(nodo.getIzq());
			this.preorden(nodo.getDer());
		}
	}
	
	public void inorden() {
		this.inorden(this.raiz);
		System.out.println();
	}
	
	private void inorden(NodoABB<E> nodo) {
		if(nodo!= null) {
			this.inorden(nodo.getIzq());
			System.out.print(nodo+",");
			this.inorden(nodo.getDer());
		}
	}
	
	public void postorden() {
		this.postorden(this.raiz);
		System.out.println();
	}
	
	private void postorden(NodoABB<E> nodo) {
		if(nodo!=null) {
			this.postorden(nodo.getIzq());
			this.postorden(nodo.getDer());
			System.out.print(nodo+",");
		}
	}
	
	public void nivel(){
		QueueLE<NodoABB<E>> cola = new QueueLE<NodoABB<E>>();
		if(this.raiz!=null) {
			cola.enqueue(this.raiz);
		}
		while(!cola.isEmpty()) {
			NodoABB<E> tmp = cola.dequeue();
			System.out.print(tmp+",");
			if(tmp.getIzq()!=null) {
				cola.enqueue(tmp.getIzq());
			}
			if(tmp.getDer()!=null) {
				cola.enqueue(tmp.getDer());
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ABB<Integer> a = new ABB<Integer>();
		a.insertar(21);
		a.insertar(13);
		a.insertar(10);
		a.insertar(18);
		a.insertar(33);
		a.insertar(25);
		a.insertar(29);
		a.insertar(27);
		a.insertar(30);
		a.insertar(40);
		System.out.print("Preorden: ");
		a.preorden();
		System.out.print("Inorden: ");
		a.inorden();
		System.out.print("Postorden: ");
		a.postorden();
		System.out.print("Nivel: ");
		a.nivel();
		a.eliminar(21);
		a.nivel();
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
