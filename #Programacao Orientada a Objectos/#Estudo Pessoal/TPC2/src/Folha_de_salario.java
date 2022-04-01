
import javax.swing.JOptionPane;



/**
 *
 * @author Fernando Gomes
 */
public class Folha_de_salario {
    
    //array de ojectos
    public static Funcionario[] funcionarios = new Funcionario[3];
    
    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado(){
        funcionarios[0] = new Func_Comissionado(JOptionPane.showInputDialog("Nome do funcionario"), JOptionPane.showInputDialog("Data de nascimento do funcionario"), JOptionPane.showInputDialog("Nome do pai do funcionario"), JOptionPane.showInputDialog("Nome da mae do funcionario"), JOptionPane.showInputDialog("Morada do funcionario"), JOptionPane.showInputDialog("Naturalidade do funcionario"), JOptionPane.showInputDialog("Data de emissao do BI do funcionario"), JOptionPane.showInputDialog("Data de ingresso do funcionario"), Double.parseDouble(JOptionPane.showInputDialog("Altura do funcionario")), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario")), Double.parseDouble(JOptionPane.showInputDialog("Percentual do funcionario")), Double.parseDouble(JOptionPane.showInputDialog("Numero vendas do funcionario")));
            
        
    }
    
    
    //metodo para adicionar funcionario produtividade
    public static void addFuncProdutividade(){
        
    }
    
    public static void main(String[] args) {
        int menu =0, submenu;
        
        menu  = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Registar um funcionario\n2 - Calcular Saldo do funcionario\n3 - Listar Funcionarios em ordem de salario"));
        
        if (menu == 1) {
            submenu  = Integer.parseInt(JOptionPane.showInputDialog("SUBBMENU\n1 - Registar 2 Funcionários Comissionado\n2 - Registar 2 Funcionário Produtividade\n3 - Sair"));
            if (submenu == 1) {
                //registar 2 Funcionários Comissionado
                for (int i = 0; i <= 2; i++) {
                     addFuncComissionado(); 
                }
                
                
            } else  if( submenu == 2) {
               // Registar 2 Funcionário Produtividade
               for (int i = 0; i <= 2; i++) {
                     addFuncProdutividade(); 
                }
            }
        } else {
        }
        
    }
    
}
