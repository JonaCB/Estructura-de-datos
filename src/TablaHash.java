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
		this.tabla = (ListaEnlazada<NodoHT<K,V>>[])new ListaEnlazada[size];
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
		int hash = Math.abs(llave.hashCode())%tabla.length;
		ListaEnlazada<NodoHT<K,V>> bucket = tabla[hash];
		bucket.insertarFin(new NodoHT<K,V>(llave,valor));
		this.size++;
	}
	
	private void rehashing() {
		TablaHash<K,V> tablahashTmp = new TablaHash<K,V>(this.tabla.length*2+1);
		NodoHT<K,V> current;
		ListaEnlazada<NodoHT<K,V>> bucket;
		for (int i = 0; i<this.tabla.length; i++) {
			bucket = this.tabla[i];
			for(int j = 0; j<bucket.size();j++) {
				current=bucket.getAt(j);
				tablahashTmp.put(current.getLlave(),  current.getValor());
			}
		}
		this.tabla = tablahashTmp.tabla;
	}
	
	public V get(K llave) throws NoSuchElementException{
		int hash = Math.abs(llave.hashCode())%tabla.length;
		ListaEnlazada<NodoHT<K,V>> bucket = tabla[hash];
		for(int i = 0; i<bucket.size();i++) {
			NodoHT<K,V> current = bucket.getAt(i);
			if(current.getLlave().equals(llave)) {
				return current.getValor();
			}
		}
		throw new NoSuchElementException("No se encontró la llave");
	}
	
	public boolean containsKey(K llave) {
		try {
			this.get(llave);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean containsValue() {
		
	}
	
	public void clear() {
		this.tabla = (ListaEnlazada<NodoHT<K,V>>[]) new ListaEnlazada[17];
		for(int i = 0; i<this.tabla.length;i++) {
			this.tabla[i] = new ListaEnlazada<NodoHT<K,V>>();
		}
		this.size=0;
		System.gc();
	}
	
	//CHECAR DELETE
	public V delete(K llave) throws NoSuchElementException{
		int hash = Math.abs(llave.hashCode())%tabla.length;
		ListaEnlazada<NodoHT<K,V>> bucket = tabla[hash];
		for(int i = 0; i<bucket.size();i++) {
			NodoHT<K,V> current = bucket.getAt(i);
			if(current.getLlave().equals(llave)) {
				this.size--;
				return bucket.borrarEn(i).getValor();
			}
		}
		throw new NoSuchElementException("No se encontró la llave");
	}
	
	public static void main(String[] args) {
		TablaHash<String, Integer> TH = new TablaHash<>();
		TH.put("uno",1);
		TH.put("dos",2);
		TH.put("tres",3);
		TH.put("cuatro",4);
		TH.put("cinco",5);
		TH.put("seis",6);
		TH.put("siete",7);
		TH.put("ocho",8);
		TH.put("nueve",9);
		TH.put("diez",10);
		TH.put("once",11);
		TH.put("doce",12);
		TH.put("trece",13);
		TH.put("catorce",14);
		TH.put("quince",15);
		
		System.out.println(TH.get("uno"));
		System.out.println(TH.get("dos"));
		System.out.println(TH.get("tres"));
		System.out.println(TH.get("cuatro"));
		System.out.println(TH.get("cinco"));
		System.out.println(TH.get("seis"));
		System.out.println(TH.get("siete"));
		System.out.println(TH.get("ocho"));
		System.out.println(TH.get("nueve"));
		System.out.println(TH.get("diez"));
		System.out.println(TH.get("once"));
		System.out.println(TH.get("doce"));
		System.out.println(TH.get("trece"));
		System.out.println(TH.get("catorce"));
		System.out.println(TH.delete("tres"));
		System.out.println(TH.containsKey("catorce"));
		System.out.println(TH.containsKey("tres"));
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
	
	public String toString() {
		return this.llave + ": " + this.valor;
	}
}
