/*
 * A01363997 Jonatan Rodrigo Cabrera Berriel
 * Regla Recursiva
 * 24/01/2018
 * --
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReglaRecursiva extends JPanel{
	
	private int nivel;
	private int x;
	
	public ReglaRecursiva() {
		super();
		this.x = 800;
		this.setPreferredSize(new Dimension(this.x,300));
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void setX(double x) {
		this.x = (int) x;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int min = 50;
		int max = this.x-50;
		int nivel = this.nivel;
		g.drawLine(min, 200, max, 200);
		this.pintaRegla(g, nivel, min, this.x-50);
	}
	
	public void pintaRegla(Graphics g, int nivel, int min, int max) {
		int mid = this.lineaMedia(min, max);
		if(nivel == 0 || nivel == 1) {
			g.drawLine(mid, 200, mid, 200-15);
		}
		else {
			this.pintaLinea(g, mid, nivel);
			this.pintaRegla(g, nivel-1, min, mid);
			this.pintaRegla(g, nivel-1 , mid, max);
			
		}
	}
	
	private void pintaLinea(Graphics g, int x, int nivel) {
		g.drawLine(x, 200, x, 200- (15*nivel));
	}
	
	private int lineaMedia(int min, int max) {
		return (min + max)/2;
	}
	
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Regla recursiva - Jonatan Cabrera A01363997 Gpo [1/2]");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReglaRecursiva regla=new ReglaRecursiva();
		ventana.add(regla);
		ventana.add(new PanelControl(regla),BorderLayout.WEST);
		ventana.pack();
		ventana.setVisible(true);
	}

}
