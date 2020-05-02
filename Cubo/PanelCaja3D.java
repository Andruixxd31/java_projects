import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


//Clase donde se pintara la caja y modificara sus atributos
public class PanelCaja3D extends JPanel implements MouseListener, MouseMotionListener {
	private Caja3D caja;
	
	public PanelCaja3D() {
		super();
		this.setPreferredSize(new Dimension(800,800));
		this.caja = new Caja3D(0,0,new Color(91,155,231));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.caja.pintaCaja(g);
	}
	
	public Caja3D getCaja() {
		return this.caja;
	}
	
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

	@Override
	public void mouseClicked(MouseEvent e) {

		Color color = JColorChooser.showDialog(this, "Escoge Color", Color.BLUE);
		this.caja.setColorFrente(color);
		this.repaint();
	}

	//* -------- Metodos no Usados --------

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
