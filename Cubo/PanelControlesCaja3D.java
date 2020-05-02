import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;

//Panel que controla los eventos de los botones
public class PanelControlesCaja3D extends JPanel implements ActionListener{
	private PanelCaja3D pCaja;
	private JButton btGuardar;
	private JButton btAbrir;
	
	public PanelControlesCaja3D(PanelCaja3D pCaja) {
		super(); 
		this.setPreferredSize(new Dimension(100,800));
		this.setBackground(Color.GRAY);
		this.pCaja = pCaja;

		//*intanciar componentes
		this.btGuardar = new JButton("Guardar");
		this.btAbrir = new JButton("Abrir");

		//*Agregar los listener 
		this.btGuardar.addActionListener(this); 
		this.btAbrir.addActionListener(this);

		//*Agregar componentes
		this.add(btGuardar);
		this.add(btAbrir);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == this.btGuardar){
			try {
				PrintWriter pw =  new PrintWriter(new FileWriter("caja.txt"));
				pw.println(this.pCaja.getCaja().toString()); //accede al metodo toString de caja para obtener los atributos
				pw.close();
			} catch (IOException ex) {
				System.out.println("No se pudo guardar bien el archivo");
			}
		}else if (evt.getSource() == this.btAbrir){
			try{
				BufferedReader bf = new BufferedReader(new FileReader("caja.txt"));
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				int x0 = Integer.parseInt(st.nextToken());
				int y0 = Integer.parseInt(st.nextToken());
				int xf = Integer.parseInt(st.nextToken());
				int yf = Integer.parseInt(st.nextToken());
				int rgb = Integer.parseInt(st.nextToken());
				this.pCaja.setCaja(new Caja3D(x0, y0, new Color(rgb))); //cambiando la caja a los valores dados
				this.pCaja.getCaja().setXYFin(xf, yf); //mandando las coordenadas finales para que se calcule el ancho y altura de la caja
				this.pCaja.repaint(); //repintando para eliminar lo que se muestra y pintar la caja guardada
				bf.close();
			}catch(FileNotFoundException ex){
				System.out.println("No se pudo econtrar el archivo");
			}
			catch (IOException ex){
				System.out.println("No se pudo leer bien el archivo");
			}
		}
	}
}