import java.util.StringTokenizer;

public class EvaluacionExpresiones {
	
	private Operador op;
	
	public EvaluacionExpresiones(String expresion) {
		this.op = new Operador(expresion);
	}
	
	public double evalua(String expresion) {
		
	}
	
	private String infixToPostfix() {
		StackLE<String> pila = new StackLE<String>();
		QueueLE<String> cola = new QueueLE<String>();
		
		for(int i = 0; i<this.op.getSize(); i++) {
			String token = this.op.getToken(i);
			try {
				Integer.parseInt(token);
				cola.enqueue(token);
			}catch(NumberFormatException e) {
				this.convert(pila, cola, token);
			}
		}
		this.vaciar(pila, cola);
		return cola.toString();
	}
	
	private void convert(StackLE<String> pila, QueueLE<String> cola, String token) {
		if(!pila.isEmpty()) {
			if(this.op.prioridad(pila.top()) < this.op.prioridad(token)) {
				pila.push(token);
			}
			else {
				this.vaciar(pila, cola);
				pila.push(token);
			}
		}
		else {
			pila.push(token);
		}
	}
	
	private void vaciar(StackLE<String> pila, QueueLE<String> cola) {
		while(!pila.isEmpty()) {
			cola.enqueue(pila.pop());
		}
	}
	
	public static void main(String[] args) {
		String operacion = "0 * 1 + 2";
		Operador op = new Operador(operacion);
		EvaluacionExpresiones ep = new EvaluacionExpresiones(operacion);
		
		System.out.println(ep.infixToPostfix());
	}
}

class Operador{
	private String operacion;
	private String[] tokens;
	private int size;
	
	public Operador(String expresion) {
		this.operacion = expresion;
		StringTokenizer st = new StringTokenizer(this.operacion," ");
		this.tokens = new String[st.countTokens()];
		int i = 0;
		this.size = st.countTokens();
		while(st.hasMoreTokens()){
			this.tokens[i++] = st.nextToken();
		}
	}
	
	public String getToken(int pos) {
		return this.tokens[pos];
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int prioridad(String s){
		switch(s) {
			case "(": return 0;
			case ")": return -1;
			case "+": return 1;
			case "-": return 1;
			case "*": return 2;
			case "/": return 2;
			case "^": return 3;
			
			default: return 0;
		}
	}
	
	public boolean higherPrecedence(String a, String b) {
		return (prioridad(a) > prioridad(b));
	}
}