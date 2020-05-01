import java.awt.BorderLayout;

import javax.swing.JFrame;

public class EspiralMain extends JFrame {

    public EspiralMain(){
        super("Un gran esprial"); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Espiral espiral = new Espiral();
        //Agregar
        this.add(espiral); 
        this.add(new EspiralControles(espiral), BorderLayout.WEST);
        //Definir como aparecera
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void main(String[] args) {
        EspiralMain ventana = new EspiralMain();
    }
}