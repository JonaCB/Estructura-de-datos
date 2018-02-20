import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiGasket extends JFrame{
	private int n;
	
	public SierpinskiGasket(){
		super("Fractal SierpinskiGasket");
		this.setSize(640 ,480);
		this.n = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel del fractal"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
		
	public void paint(Graphics g) {
		super.paint(g);
		Point a = new Point(20, 380);
		Point b = new Point(620, 380);
		Point c = new Point(320, 50);
		
		this.pintaTriangulos(g, n, a, b, c);
	}
	
	private void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	private Point puntoMedio(Point a, Point b) {
		return new Point ((a.x + b.x)/2 , (a.y + b.y)/2);
	}
	
	private void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c) {
		if(n == 0) {
			this.pintaLineas(g, a, b);
			this.pintaLineas(g, b, c);
			this.pintaLineas(g, c, a);
		}
		else {
			Point pmAB = this.puntoMedio(a, b),
				  pmBC = this.puntoMedio(b, c),
				  pmCA = this.puntoMedio(c, a);
			
			this.pintaTriangulos(g, n-1, a, pmAB, pmCA);
			this.pintaTriangulos(g, n-1, pmAB, b, pmBC);
			this.pintaTriangulos(g, n-1, pmCA, pmBC, c);
			
		}
	}
	
	public static void main(String[] args) {
		SierpinskiGasket fractal = new SierpinskiGasket();
	}

}
/*
public void pintaRaya(Graphics g, Point a, Point b, int nivel) {
		if(nivel == 1) {
			Point pm = lineaMedia(a,b);
			this.pintaLinea(g, pm, nivel);
		}
		else {
			Point pm = lineaMedia(a,b);
			Point pmA = lineaMedia(a,pm);
			Point pmB = lineaMedia(pm, b);
			
			this.pintaLinea(g, pmA, nivel-1);
			this.pintaLinea(g, pmB, nivel-1);
		}
	}
	
	private Point lineaMedia(Point a, Point b) {
		return new Point((a.x + b.x)/2 , a.y);
	}
	
	public void pintaLinea(Graphics g, Point a, int nivel) {
		g.drawLine(a.x, a.y, a.x, (a.y - 15*nivel));
		//g.drawLine(a.x, a.y, b.x, b.y);
	}
	*/
