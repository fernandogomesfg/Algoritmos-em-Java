package quadradocirculo;

import static java.awt.Color.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Fernando Gomes
 */
public class QuadradoCirculo extends JFrame {

    public QuadradoCirculo() {
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void paintCompoent(Graphics g){
        g.setColor(blue);
        g.drawRect(200, 200, 300, 300);
//desenhar e pintar de vermelho a circunferencia    
        g.setColor(red);
        g.fillOval(200, 200, 300, 300);
//pintar as linhas da circunferencia    
        g.setColor(green);
        g.drawOval(200, 200, 300, 300);
//Criar uma recta no centro do quadrado -outro teste
        g.setColor (green);
        g.drawLine(350, 500, 350, 200);
    }

    public static void main(String[] args) {
        QuadradoCirculo quadradoCirculo = new QuadradoCirculo();

    }

}
