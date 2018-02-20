import java.util.StringTokenizer;

public class EvaluacionExpresiones {
	
	private Operador op;
	
	public double evalua(String expresion) {
		this.op = new Operador(expresion);
		
	}
	
	private String infixToPostfix() {
		
	}
	
	public static void main(String[] args) {
		String operacion = "0 + 1 - 2";
		StringTokenizer st = new StringTokenizer(operacion, " ");
		String[] tokens = new String[st.countTokens()];
		int size = st.countTokens();
		int i = 0;
		while(st.hasMoreTokens()) {
			tokens[i] = st.nextToken();
			System.out.println(i + " " + tokens[i++]);
		}
	}
}

class Operador{
	private String operacion;
	private String[] tokens;
	
	public Operador(String expresion) {
		this.operacion = expresion;
		StringTokenizer st = new StringTokenizer(this.operacion," ");
		this.tokens = new String[st.countTokens()];
		int i = 0;
		while(st.hasMoreTokens()){
			this.tokens[i++] = st.nextToken();
		}
	}
	
	public int prioridad(String s){
		switch(s) {
			case "+": return 1;
			case "-": return 1;
			case "*": return 2;
			case "/": return 2;
			case "^": return 3;
			
			default: return 0;
		}
	}
}