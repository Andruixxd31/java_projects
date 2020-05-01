import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;

public class EspiralControles extends JPanel implements ChangeListener{

    private JSlider slider; 
    private Espiral espiral;

    public EspiralControles(Espiral espiral){
        super(); 
        this.espiral = espiral;
        this.setPreferredSize(new Dimension(100,800));
        slider = new JSlider(JSlider.VERTICAL,0,100,10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        this.slider.addChangeListener(this);
        this.add(slider);
    }

    @Override
    public void stateChanged(ChangeEvent evt){
        this.espiral.setAnchoEspiral(this.slider.getValue());
    }

}