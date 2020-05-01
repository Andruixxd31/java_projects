import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    
    public Ventana(){
        super("Graficador");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        PanelCaja3D pc = new PanelCaja3D(); 
        this.add(pc); 
        this.add(new PanelControlesCaja3D(pc), BorderLayout.WEST);
        this.setVisible(true);
        this.pack(); 
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}