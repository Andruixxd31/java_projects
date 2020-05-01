import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Caja3D {
	private int x0,
				y0,
				ancho,
				alto;

	private int[] vxTapa,
				  vyTapa,
				  vxPared,
				  vyPared;

	private Color colorFrente,
				  colorTapa,
				  colorPared;

	public Caja3D(int x0,int y0,Color color) {//Inicializa x0,y0,vxTapa,vyTapa,vxPared,vyPared y los 3 colores
		this.x0 = x0;
		this.y0 =y0;
		this.vxTapa = new int[4];
		this.vyTapa = new int[4];
		this.vxPared = new int[4];
		this.vyPared = new int[4];
		this.colorFrente = color;
		this.colorPared = color;
		this.colorTapa = color;
	}
	
	public void setXYIni(int x0,int y0) {//Inicializar x0,y0, alto y ancho en 0
		this.x0=x0;
		this.y0=y0;
		this.alto=0;
		this.ancho=0;
	}
	
	public void setXYFin(int xf,int yf) {//Recibe la coordenada inferior izquierda de la caja y con eso settea ancho, alto y recalculo los v�rtices
		this.ancho = xf - this.x0;
		this.alto = yf - this.y0;
		this.calculaVertices();
	}

	private void calculaVertices() {//Calcula el valor de cada v�rtice vxTapa, vyTapa, vxPared y vyPared
		//*vxTapa 
		this.vxTapa[0]=this.x0;
		this.vxTapa[1]=(int)(this.x0+this.ancho*0.15);
		this.vxTapa[2]=(int)(this.x0+this.ancho);
		this.vxTapa[3]=(int)(this.x0+this.ancho*0.85);
		//*vyTapa
		this.vyTapa[0]=(int)(this.y0+this.alto*0.15);
		this.vyTapa[1]=this.y0;
		this.vyTapa[2]=this.y0;
		this.vyTapa[3]=(int)(this.y0+this.alto*0.15);
		//*vxPared
		this.vxPared[0]=(int) (this.x0+this.ancho-this.ancho*0.15);
		this.vxPared[1]=this.x0+this.ancho;
		this.vxPared[2]=this.x0+this.ancho;
		this.vxPared[3]=(int) (this.x0+this.ancho*0.85);
		//*vyPared
		this.vyPared[0]=(int)(this.y0+this.alto*0.15);
		this.vyPared[1]=this.y0;
		this.vyPared[2]=(int)(this.y0+this.alto*0.85);
		this.vyPared[3]=this.y0+this.alto;
	}

	//Recibe el color que tendr� el frente de la Caja y lo settea
	//el color de la Tapa (superior) es 20% mayor en cada componente (RGB)
	//en caso de que al incrementar el 20% este valor fuera mayor a 255 entonces lo deja como 255
	//Ejemplo si colorFrente vale 100,100,100 entonces colorTapa es 120,120,120
	//El color de la pared lateral es 20% menor cada componente (RGB) que el del frente de la caja.
	//Ejemplo si colorFrente vale 100,100,100 entonces colorPared es 80,80,80
	public void setColorFrente(Color color) {
		this.colorFrente = color;
		this.colorPared = new Color(
								(int)(color.getRed()*.8), 
								(int)(color.getGreen()*.8),
								(int)(color.getBlue()*.8)
								);
		this.colorTapa = new Color(
								(int)(color.getRed()*1.2) > 255 ? 255 : (int)(color.getRed()*1.2),
								(int)(color.getGreen()*1.2) > 255 ? 255 : (int)(color.getGreen()*1.2),
								(int)(color.getBlue()*1.2) > 255 ? 255 : (int)(color.getBlue()*1.2)
								);
	}
	
	// Este método pinta la caja de acuerdo al valor de sus atributos
	//Si el ancho y alto no son mayores a 0 entonces no dibuja nada
	public void pintaCaja(Graphics g) {
		this.setColorFrente(this.colorFrente);
		if (this.alto > 0 && this.ancho > 0) {
			g.setColor(colorFrente); 
			g.fillRect(
					this.x0, 
					(int)(this.y0 + this.alto * .15), 
					(int)(this.ancho *.85),
					(int)(this.alto * .85)
					);
			g.setColor(colorPared); 
			g.fillPolygon(vxPared, vyPared, 4);
			g.setColor(colorTapa); 
			g.fillPolygon(vxTapa, vyTapa, 4);
		}
	}
	
	
	//Regresa el objeto en el siguiente formato
	//x0 y0 xf yf colorRGB
	//Hay un espacio en blanco entre cada valor. xf y yf se refieren a la coordenada inferior derecha de la caja
	public String toString() {
		return this.x0 + " " + this.y0 + " " + (this.x0+this.ancho) + " " + (this.y0+this.alto) + " " + this.colorFrente.getRGB();
	}
}