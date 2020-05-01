import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JPanel;

//Esta clase es un Panel capaz de controlar los eventos de los botones que contiene
public class PanelControlesCaja3D extends JPanel implements ActionListener{
	private PanelCaja3D pCaja;
	private JButton btGuardar;
	private JButton btAbrir;
	
	//Completa el contructor de manera que inicialice el panel y cada uno de sus atributos.
	//Es posible que tengas que modificar la firma del constructor
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
				pw.println(this.pCaja.getCaja().toString());
				pw.close();
			} catch (IOException ex) {
				System.out.println("No se pudo guardar bien el archio");
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
				this.pCaja.setCaja(new Caja3D(x0, y0, new Color(rgb)));
				this.pCaja.getCaja().setXYFin(xf, yf);
				this.pCaja.repaint();
				bf.close();
			}catch(FileNotFoundException ex){
				System.out.println("No se pudo econtrar el archivo");
			}
			catch (IOException ex){
				System.out.println("No se pudo leer bien el archivo");
			}
		}
	}

	//M�todo para controlar los eventos de los botones
	//Si se oprime el bot�n guardar deber� escribir en un archivo de texto llamado caja.txt
	//en la carpeta default la informaci�n de la caja que est� en el panel y deber� hacerlo con el siguiebnte formato
	//x0 y0 xf yf colorRGB
	//Hay un espacio en blanco entre cada valor. xf y yf se refieren a la coordenada inferior derecha de la caja	
	//Si se oprime el bot�n abrir deber� crear la caja que esta representada en el archivo caja.txt
	//Y que se muestre en el PanelCaja3D
	// public void XXX(YYY evt) {
	// }
}