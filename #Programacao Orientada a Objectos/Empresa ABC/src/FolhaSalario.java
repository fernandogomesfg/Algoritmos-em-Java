
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class FolhaSalario {

    //array de funcionarios
    public static Funcionario[] funcionarios = new Funcionario[3];
    
    
    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado(){
        funcionarios [0] = new Func_comissionado(JOptionPane.showInputDialog("Nome do funcionario comissionado"), JOptionPane.showInputDialog("Numero de BI do funcionario comissionado"), JOptionPane.showInputDialog("Estado Civil do funcionario comissionado"), JOptionPane.showInputDialog("Data de nascimento do funcionario comissionado"), JOptionPane.showInputDialog("Morada do funcionario comissionado"), JOptionPane.showInputDialog("Nome do funcionario comissionado"), JOptionPane.showInputDialog("Nome da mae do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), JOptionPane.showInputDialog("Sexo do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Altura do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem de vendas do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado")));
        
    }
    
    
    //metodo para adicionar funcionario produtividade
    public static void addFuncprodutividade(){
        funcionario [1] = new 
    }

    public static void main(String[] args) {
        int menu = 0, sub_menu = 0, opcao = 0;
        menu = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario\n0 - Sair"));
        if (menu == 1) {
            sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Registar 2 Funcionários Comissionados\n2 - Registar 2 Funcionário Produtividade\n0 - Sair"));
            if (sub_menu == 1) {
                //metodo para registar 2 funcionarios comissionados
                

            } else if (sub_menu == 2) {
                //metodo para registar 2 funcionarios produtividade

            } else if (sub_menu == 0) {
                //caixa que pergunta se quer sair do sistema
                opcao = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opcao == 0) {
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "########");    //nao sei como fazer para voltar
                }
            }

        } else if (menu == 2) {
            sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Calcular salario do funcionario comissionado\n2 - Calcular salario funcionário produtividade\n0 - Sair"));
            //metodos para calcular saldo do funcionario
            if (sub_menu == 1) {
                //metodo para calcular salario do funcionnario comissionado

            } else if (sub_menu == 2) {
                //metodo para calcular salario do funcionnario produtividade
            } else if (sub_menu == 0) {
                //caixa que pergunta se quer sair do sistema
                opcao = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opcao == 0) {
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "########");    //nao sei como fazer para voltar
                }

            }

        } else if (menu == 0) {
            //caixa que pergunta se quer sair do sistema
                opcao = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opcao == 0) {
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "########");    //nao sei como fazer para voltar
                }
        }
    }
}
