
public class Fibonacci {

	public static long fibonacci(int n) {
		if(n==0 || n == 1) {
			return 1;
		}
		
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static long fibonacciTabla(int n) {
		long[] valores = new long[n+1];
		valores[0] = valores[1] = 1;
		return fibonacciTabla(n, valores);
	}
	
	public static long fibonacciTabla(int n, long[] valores) {
		if(valores[n] != 0) {
			return valores[n];
		}
		else {
			return valores[n] = fibonacciTabla(n-1,valores) + fibonacciTabla(n-2,valores);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(Fibonacci.fibonacci(9));
		System.out.println(Fibonacci.fibonacciTabla(300));
	}
}
