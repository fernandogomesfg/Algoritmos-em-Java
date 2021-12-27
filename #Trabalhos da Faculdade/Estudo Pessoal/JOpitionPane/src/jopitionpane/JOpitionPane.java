package jopitionpane;

import javax.swing.JOptionPane;

public class JOpitionPane {

    public static void main(String[] args) {
        int i1;
        i1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um int ", "int", JOptionPane.QUESTION_MESSAGE));
        JOptionPane.showMessageDialog(null, "Valor do int: " + i1, "int", JOptionPane.INFORMATION_MESSAGE);

    }
}
