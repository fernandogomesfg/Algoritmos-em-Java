
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class FolhaSalario {

    //Arraylist
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado() {
        Funcionario funcComissionado = new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado")));
        funcionarios.add(funcComissionado);
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(funcionarios.get(i));
        }
    }

    //metodo para imprimir salario do funcionario comissionado
    /*
    public static void printSalarioComissionado() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios. instanceof FuncComissionado) {
                System.out.println(funcionarios.get(i)); 
            }
              
        }
    }
     */
    //metodo para adicionar funcionario comissionado
    public static void addFuncProdutividade() {
        Funcionario funcProdutividade = new FuncProdutividade(JOptionPane.showInputDialog("Numero do BI do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Unidade produzida do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor da unidade produzida funcionario produtividade")));
        funcionarios.add(funcProdutividade);
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncProdutividade() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(funcionarios.get(i));
        }
    }

    //metodo para imprimir salario do funcionario produtividade
    /*
    public static void printSalarioComissionado() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios. instanceof FuncComissionado) {
                System.out.println(funcionarios.get(i)); 
            }
              
        }
    }
     */
 
    /*
     //metodo para listar a informação de todos funcionários 
    //registados pela ordem crescente do seu salário.
    public static void printSort() {
        
        Arrays.sort(funcionarios);  //ordenacao do array
        System.out.println("Ordem dos salarios");
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i].toString());
            
        }
    }
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int menu = 0, sub_menu = 0, opcao = 0;

        //inicio do menu
        menu = Integer.parseInt(JOptionPane.showInputDialog("MENU\nEscolha uma opcao\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario 3- Listar Funcionarios\n0 - Sair"));
        switch (menu) {
            //MENU case 1 -  Rigistar Funcionarios
            case 1:
                sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Registar 2 Funcionários Comissionados\n2 - Registar 2 Funcionário Produtividade\n0 - Sair"));
                switch (sub_menu) {
                    case 1:
                        //registrar dois funcionarios comissionados
                        for (int i = 0; i < 2; i++) {
                            //System.out.println("Digite dados do " +(i + 1) +"o funcionario");
                            JOptionPane.showMessageDialog(null, "Digite dados do " + (i + 1) + "o funcionario");
                            //adicionando o metodo que adiciona um comissionario
                            addFuncComissionado();

                        }
                        //metodo para mostar os funcionarios inseridos - para teste
                        listFuncComissionario();
                        break;
                    case 2:
                        //registrar dois funcionarios comissionados
                        for (int i = 0; i < 2; i++) {
                            //System.out.println("Digite dados do " +(i + 1) +"o funcionario");
                            JOptionPane.showMessageDialog(null, "Digite dados do " + (i + 1) + "o funcionario");
                            //adicionando o metodo que adiciona um comissionario
                            addFuncProdutividade();

                        }
                        //metodo para mostar os funcionarios inseridos - para teste
                        listFuncProdutividade();
                        break;
                    case 0:
                        //codigo para sair
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcao Invalida!!!!\nObrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            
            //MENU case 2 -  Calcular Saldo do Funcionario     
            case 2:
                
                break;
            
            //MENU case 3 - Listar Funcionarios    
            case 3:
                break;
            
            //MENU case 0 - Sair 
            case 0:
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opcao Invalida!!!!\nObrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                    

        }

    }

}
