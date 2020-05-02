import java.awt.Color;
import java.awt.Graphics;

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

	private void calculaVertices() {//Calcula el valor de cada vertice vxTapa, vyTapa, vxPared y vyPared
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
	//El color de la tapa es 20% mayor y el de la pared es 20% menor
	public void setColorFrente(Color color) {
		this.colorFrente = color;
		this.colorPared = new Color(
								(int)(color.getRed()*.8), 
								(int)(color.getGreen()*.8),
								(int)(color.getBlue()*.8)
								);
		this.colorTapa = new Color(
								(int)(color.getRed()*1.2) > 255 ? 255 : (int)(color.getRed()*1.2), //si da mayor a 255 el valor se settera a 255
								(int)(color.getGreen()*1.2) > 255 ? 255 : (int)(color.getGreen()*1.2),
								(int)(color.getBlue()*1.2) > 255 ? 255 : (int)(color.getBlue()*1.2)
								);
	}

	public Color getColorFrente(){
		return this.colorFrente;
	}
	
	public void pintaCaja(Graphics g) {
		this.setColorFrente(this.colorFrente);
		if (this.alto > 0 && this.ancho > 0) { //no pinta si no hay ancho y altura
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
	
	public String toString() {
		return this.x0 + " " + this.y0 + " " + (this.x0+this.ancho) + " " + (this.y0+this.alto) + " " + this.colorFrente.getRGB();
	}
}