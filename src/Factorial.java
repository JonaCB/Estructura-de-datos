
public class Factorial {

	public static long factorial(int number) {
		if(number == 0) {
			return 1;
		}
		else {
			return number*factorial(number-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Factorial.factorial(6));
	}
}
