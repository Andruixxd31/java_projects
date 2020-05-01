import javax.swing.*;
import java.awt.*; 

public class Espiral extends JPanel{
    
    private int anchoEspiral,
                anchoDelta;
    

    //*-------------------------- Constructor ----------------------------------

    public Espiral(){
        super();
        //Dimensiones, hilo
        this.setPreferredSize(new Dimension(800,800));
        this.setBackground(Color.RED);
        anchoEspiral = 30;
    }

    private void dibujaEspiral(Graphics g){
        int centerX = 800 / 2;
        int centerY = 800 / 2;
        int anchoI=this.anchoEspiral;

        anchoDelta = 30;
        for (int i = 0; i < 5; i++) {
            g.drawArc(centerX - anchoI, centerY - anchoI, 2 * anchoI, 2 * anchoI, 0, 180);
            anchoI += anchoDelta;
            g.drawArc(centerX - anchoI, centerY - anchoI, 2 * anchoI - anchoDelta, 2 * anchoI, 180, 180);
        }
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.dibujaEspiral(g);
    }


    //*-------------------------- Metodos ----------------------------------


    //? Getters 
    public void setAnchoEspiral(int anchoEspiral){
        this.anchoEspiral = anchoEspiral; 
        repaint();
    }

    public void setAnchoDelta(int anchoDelta){
        this.anchoDelta = anchoDelta; 
        repaint();
    }
}