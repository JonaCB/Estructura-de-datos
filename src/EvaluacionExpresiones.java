import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class EvaluacionExpresiones {
	
	private Operador op;
	
	public EvaluacionExpresiones(String expresion) {
		this.op = new Operador(expresion);
	}
	
	public double evalua(String expresion) {
		QueueLE<String> cola = this.infixToPostfix();
		StackLE<Double> pila = new StackLE<Double>();
		int size = cola.size();
		for(int i = 0; i<size; i++) {
			String current = cola.dequeue();
			try {
				pila.push(Double.parseDouble(current));
			}catch(NumberFormatException e) {
				double val2 = pila.pop();
				double val1 = pila.pop();
				
				switch(current){
					case "+": {
						pila.push(val1+val2);
						break;
					}
					case "-":{
						pila.push(val1-val2);
						break;
					}
					case "*": {
						pila.push(val1*val2);
						break;
					}
					case "/": {
						pila.push(val1/val2);
						break;
					}
					case "^": {
						pila.push(Math.pow(val1, val2));
						break;
					}
				}
			}
		}
		return pila.pop();
	}
	
	private QueueLE<String> infixToPostfix() {
		StackLE<String> pila = new StackLE<String>();
		QueueLE<String> cola = new QueueLE<String>();
		
		for(int i = 0; i<this.op.getSize(); i++) {
			String token = this.op.getToken(i);
			try {
				Integer.parseInt(token);
				cola.enqueue(token);
			}catch(NumberFormatException e) {
				try {
					if(pila.isEmpty()) {
						pila.push(token);
					}
					else if(token.equals("(")) {
						pila.push(token);
					}
					else if(token.equals(")")) {
						while(!pila.isEmpty()) {
							if(pila.top().equals("(")) {
								break;
							}
							cola.enqueue(pila.pop());
						}
						if(pila.top().equals("(")) {
							pila.pop();
						}
					}
					else {
						this.convert(pila, cola, token);
					}
				}catch(NoSuchElementException ex) {}
			}
		}
		this.vaciar(pila, cola);
		return cola;
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
			try{
				if(pila.top().equals("(")) {
					pila.pop();
				}
				cola.enqueue(pila.pop());
			}catch(NoSuchElementException e) {}
		}
	}
	
	public static void main(String[] args) {
		String operacion = "2 / 6 + 4 * 5 - 10";
		Operador op = new Operador(operacion);
		EvaluacionExpresiones ep = new EvaluacionExpresiones(operacion);
		
		System.out.println(ep.infixToPostfix());
		System.out.println(ep.evalua(operacion));
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