/*
 * Se puede deducir facilmente que dos reinas están en la misma diagonal si la
 * R1(j,k y R2(k,l) se cumple que |j-l| = |i-k|
 * 
 * n = fila
 * i = columna
 */

public class NReinas {
	
	private boolean valido(int[] reinas, int f, int c) {
		//Revisa que la columna no esté previamente ocupada
		for(int i = 0; i<f; i++) {
			if(reinas[i] == c) {
				return false;
			}
			//Revisar que no haya otra reina en esa diagonal
			else if(Math.abs(f-i) == Math.abs(c-reinas[i])) {
				return false;
			}
			
		}
		//Es una posición válida
		return true;
	}
	
	public void imprimeTablero(int[] reinas) {
		for(int i = 0; i < reinas.length; i++) {
			System.out.print(reinas[i]+",");
		}
		System.out.println();
	}
	
	public void nReinas(int n, int[] reinas) {
		for(int i = 0; i<reinas.length; i++) {
			if(this.valido(reinas, n, i)) {
				reinas[n] = i;
				if(n== reinas.length-1) {
					imprimeTablero(reinas);
				}
				else {
					this.nReinas(n+1, reinas);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NReinas nr =  new NReinas();
		int[] reinas = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		nr.nReinas(0, reinas);
		
	}

}
