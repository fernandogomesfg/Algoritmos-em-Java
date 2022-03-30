
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class RecursosHumanos {

    //array de colaboradores
    public static Colaborador[] colaboradores = new Colaborador[3];

    //metodo para adiconar administradores
    public static void addAdministrador() {
        colaboradores[0] = new Administrador(JOptionPane.showInputDialog("Nome do administrador"), JOptionPane.showInputDialog("Endereço do administrador"), JOptionPane.showInputDialog("Número de telefone do administrador"), Integer.parseInt(JOptionPane.showInputDialog("Código do sector do adminstrador")), Double.parseDouble(JOptionPane.showInputDialog("Salário do administrador")), Double.parseDouble(JOptionPane.showInputDialog("Imposto do administrador em percentagem")), Double.parseDouble(JOptionPane.showInputDialog("Ajuda de custos do administrador")));
    }

    //metodo para listar administradores
    public static void listaAdministrador() {
        System.out.println("\nAdministradores");
        for (int i = 0; i < colaboradores.length; i++) {
            if (colaboradores[i] instanceof Administrador) {
                System.out.println(colaboradores[i].toString()
                );
            }
        }
    }

    //metodo para criar um operario
    public static void addOperario() {
        colaboradores[1] = new Operario(JOptionPane.showInputDialog("Nome do operário"), JOptionPane.showInputDialog("Endereço do operário"), JOptionPane.showInputDialog("Número de telefone do operário"), Integer.parseInt(JOptionPane.showInputDialog("Código do sector do operário")), Double.parseDouble(JOptionPane.showInputDialog("Salário do operário")), Double.parseDouble(JOptionPane.showInputDialog("Imposto do operário")), Double.parseDouble(JOptionPane.showInputDialog("Valor de vendas do operário")), Double.parseDouble(JOptionPane.showInputDialog("Comissão de vendas do operário em percentagem")));
    }

    //metodo para listar operarios
    public static void listaOperario() {
        System.out.println("\nOperarios");
        for (int i = 0; i < colaboradores.length; i++) {
            if (colaboradores[i] instanceof Operario) {
                System.out.println(colaboradores[i].toString()
                );
            }

        }
    }

    /*
    public static void addColaborador() {
        colaboradores[3] = new Colaborador("Fernando Gomes Colaborador", "Maputo", "840357939", 1, 5000, 0.1);

        
        System.out.println("Colaborador:");

        System.out.println(colaboradores[3].toString());
        System.out.println("O salario: " + colaboradores[3].calcularSalario() + "\n");

    }
     */
    public static void main(String[] args) {

        int tipoColaorador = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Administrador\n2 - Operario"));
        if (tipoColaorador == 1) {
            addAdministrador();
            listaAdministrador();
        } else if (tipoColaorador == 2) {
            addOperario();
            listaOperario();
        }

    }

}
