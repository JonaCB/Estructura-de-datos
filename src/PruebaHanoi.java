
public class PruebaHanoi {
	private StackInteger[] stacks = new StackInteger[3];
	
	public PruebaHanoi() {
		for(int i = 0; i<3; i++){
			this.stacks[i] = new StackInteger();
		}
	}
	
	public void pushDisks(int n) {
		for(int i = n; i>0; i--) {
			this.stacks[0].push(i);
		}
		this.mueve(n, 0, 2, 1);
		
	}
	
	 public void mueve(int n, int from, int to, int using)
     {
         if (n == 1){
             stacks[to].push(stacks[from].pop());
         }         
         else {
        	 mueve(n-1,from, using, to);
        	 stacks[to].push(stacks[from].pop());
        	 mueve(n-1,using, to, from);
         }
     }
	
	public static void main(String[] args) {
		PruebaHanoi p = new PruebaHanoi();
		p.pushDisks(3);
		System.out.println(p.stacks[2]);
	}
}

class StackInteger extends StackLE<Integer>{}
