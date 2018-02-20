/*
 * A01363997 Jonatan Rodrigo Cabrera Berriel
 * PanelControl
 * 24/01/2018
 * --
 */

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControl extends JPanel implements ChangeListener{

	private ReglaRecursiva regla;
	private JSlider slider;
	
	public PanelControl(ReglaRecursiva regla) {
		super();
		this.regla = regla;
		this.slider = new JSlider(JSlider.VERTICAL, 1, 10 , 5);
		this.slider.setSize(100,100);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(this);
		this.slider.setVisible(true);
		this.regla.setNivel(this.slider.getValue());
		this.add(this.slider);
		regla.addComponentListener(new ComponentListener() 
		{  

				@Override
				public void componentHidden(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void componentMoved(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void componentResized(ComponentEvent evt) {
					ReglaRecursiva reg = (ReglaRecursiva)evt.getSource();
					
					Dimension dim = reg.getSize();
					regla.setX((dim.getWidth()));
				}

				@Override
				public void componentShown(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		});
	}

	public void stateChanged(ChangeEvent arg0) {
		this.regla.setNivel(this.slider.getValue());
		regla.repaint();
	}
	
}
