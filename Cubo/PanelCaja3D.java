import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

//Esta clase debe ser un panel capaz de controlar los eventos requiridos para dar 
//la funcionalidad al programa
public class PanelCaja3D extends JPanel implements MouseListener, MouseMotionListener {
	private Caja3D caja;
	
	//Inicializa el panel y el objeto caja en x y y en 0 y con color frontal RGB(91,155,231)
	//En caso de ser necesario hacer otra acci�n lo puedes realizar
	public PanelCaja3D() {
		super();
		this.setPreferredSize(new Dimension(800,800));
		this.caja = new Caja3D(0,0,new Color(91,155,231));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	//Aqu� escribe el m�todo que va a encargarse de pintar la caja en el panel
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.caja.pintaCaja(g);
	}
	
	
	//Getter del atributo caja
	public Caja3D getCaja() {
		return this.caja;
	}
	
	//Setter del atributo caja. 
	public void setCaja(Caja3D caja) {
		this.caja = caja;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.caja.setXYFin(e.getX(), e.getY());
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.caja.setXYIni(e.getX(), e.getY());
	}

	//* -------- Metodos no Usados --------

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Color color = JColorChooser.showDialog(this, "Escoge Color", Color.BLUE);
		this.caja.setColorFrente(color);
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
