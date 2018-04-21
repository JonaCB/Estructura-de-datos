
public class Heap{
	private int size;
	private int[] heap;
	
	public Heap(int size) {
		this.size = 0;
		this.heap = new int[size];
	}
	
	public Heap() {
		this(15);
	}
	
	public Heap(int[] arreglo) {
		this.size = arreglo.length-1;
		this.heap = arreglo;
		int index = this.size/2 - 1;
		this.hippify(index);
	}
	
	private void hippify(int index) {
		if(index>=0) {
			System.out.print(index+ ": ");
			System.out.println(this.print());
			int h1 = this.heap[index*2 + 1];
			int h2 = this.heap[index*2 + 2];
			int mayor = (h1>h2) ? index*2+1 : index*2+2;
			if(this.heap[mayor]>this.heap[index]) {
				swap(index,mayor);
				if(index!=this.size/2-1 && (this.heap[index*2 + 1] > this.heap[mayor] || this.heap[index*2 + 2]>this.heap[mayor])) {
					hippify(++index);
				}
			}
			hippify(--index);
		}	
	}
	
	private void swap(int este, int otro) {
		int tmp = this.heap[este];
		this.heap[este] = this.heap[otro];
		this.heap[otro] = tmp;
	}
	
	public String print() {
		String res = "";
		for(int a:heap) {
			res+=a+",";
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = {15,60,72,70,56,32,62,92,45,30,65};
		Heap h = new Heap(array);
		System.out.println(h.print());
	}

}
