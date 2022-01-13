package quadradocirculo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Fernando Gomes
 */
public class QuadradoCirculo extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        g.setColor(Color.blue);
        g.drawRect(100, 100, 500, 500);
        g.setColor(Color.black);
        g.drawOval(100, 100, 500, 500);
        g.setColor(Color.blue);
        g.fillOval(100, 100, 500, 500);
        
        
         */
 /*
        g.setColor(Color.yellow);
        g.drawLine(150, 100, 100, 50);
        g.setColor(Color.red);
        g.drawLine(150, 100, 50, 100);
        g.setColor(Color.blue);
        g.drawLine(100, 50, 50, 100);
         */

        //g.drawRect(100, 100, 250, 250);
        g.drawLine(100, 350, 225, 100);
        g.drawLine(350, 350, 225, 100);
        g.drawLine(100, 350, 350, 350);
        
        g.drawLine(10, 35, 22, 10);
        g.drawLine(35, 35, 22, 10);
        g.drawLine(10, 35, 35, 35);
    }

    public static void main(String[] args) {
        JFrame tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(800, 800);
        tela.add(new QuadradoCirculo());
        tela.setVisible(true);
    }

}
