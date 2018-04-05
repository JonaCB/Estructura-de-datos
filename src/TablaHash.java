import java.util.NoSuchElementException;

public class TablaHash <K,V>{
	private ListaEnlazada<NodoHT<K,V>>[] tabla;
	private int size;
	private final static double LOAD_FACTOR = 0.8;
	
	public TablaHash() {
		this(17);
	}
	
	@SuppressWarnings("unchecked")
	public TablaHash(int size) {
		this.tabla = (ListaEnlazada<NodoHT<K,V>>[])new Object[size];
		for(int i = 0; i<this.tabla.length;i++) {
			this.tabla[i] = new ListaEnlazada<NodoHT<K,V>>();
		}
		this.size=0;
	}
	//Revisar el factor de carga
	//Revisar si el elemento ya está en la lista
	
	public void put(K llave, V valor) {
		if((double)this.size/this.tabla.length>=TablaHash.LOAD_FACTOR) {
			rehashing();
		}
		int hash = llave.hashCode()%tabla.length;
		ListaEnlazada<NodoHT<K,V>> bucket = tabla[hash];
		bucket.insertarFin(new NodoHT<K,V>(llave,valor));
		this.size++;
	}
	
	private void rehashing() {
		TablaHash<K,V> tablahashTmp = new TablaHash<K,V>(this.tabla.length*2+1);
		NodoHT<K,V> current;
		for (int i = 0; i<this.tabla.length; i++) {
			ListaEnlazada<NodoHT<K,V>> bucket= this.tabla[i];
			for(int j = 0; j<bucket.size();j++) {
				current=bucket.getAt(j);
				tablahashTmp.put(current.getLlave(),  current.getValor());
			}
		}
		this.tabla = tablahashTmp.tabla;
	}
	
	public V get(K llave) throws NoSuchElementException{
		int hash = llave.hashCode()%tabla.length;
		ListaEnlazada<NodoHT<K,V>> bucket = tabla[hash];
		for(int i = 0; i<bucket.size();i++) {
			NodoHT<K,V> current = bucket.getAt(i);
			if(current.getLlave().equals(llave)) {
				return current.getValor();
			}
		}
		throw new NoSuchElementException("No se encontró la llave ");
	}
	
	public static void main(String[] args) {

	}

}

class NodoHT<K,V>{
	private K llave;
	private V valor;
	
	public NodoHT(K llave, V valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}
	
	public K getLlave() {
		return llave;
	}
	public void setLlave(K llave) {
		this.llave = llave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
}
