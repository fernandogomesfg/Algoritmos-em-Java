
import javax.swing.JOptionPane;


/**
 *
 * @author Fernando Gomes
 */
public class FolhaSalario {

    //array de funcionarios
    public static Funcionario[] funcionarios = new Funcionario[3];

    public static void main(String[] args) {
        int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario\n0 - Voltar"));
        if (menu == 1) {
           int sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Registar 2 Funcionários Comissionados\n2 - Registar 2 Funcionário Produtividade\n0 - Voltar"));
            if (sub_menu == 1) {
                //metodo para registar 2 funcionarios comissionados
                
            } else if (sub_menu == 2) {
                //metodo para registar 2 funcionarios produtividade
                
            }else if(sub_menu == 0){
                //JOptionPane.showConfirmDialog(this, "Deseja sair do sistema?", "Sair", JOptionPane.yes, JOptionPane.WARNING_MESSAGE);
            }
            
        } else if (menu == 2) {
            
        }

        
        /*int op = 0;

        switch (op) {
            case 1: 
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:;

        }
*/

    }
}
