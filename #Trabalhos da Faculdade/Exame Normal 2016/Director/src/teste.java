
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class teste {

    public static void main(String[] args) {
        Director d1 = new Director("Fernando Gomes", "DMI", 50000);
        Director d2 = new Director();
        d1.print();
        System.out.println("\n");
        d1.alteraSalario(500);
        System.out.println("\n");
        d1.print();

        Director[] directores = new Director[2];
        //preenchimento
        for (int i = 0; i < directores.length; i++) {
            directores[i] = new Director(JOptionPane.showInputDialog("Nome"), JOptionPane.showInputDialog("Departamento"), Double.parseDouble(JOptionPane.showInputDialog("Salario")));
        }

    }
}
