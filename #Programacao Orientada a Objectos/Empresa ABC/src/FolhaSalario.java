
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Gomes
 */
public class FolhaSalario {

    //array de funcionarios
    public static Funcionario[] funcionarios = new Funcionario[3];

    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado() {
        funcionarios[0] = new Func_comissionado(JOptionPane.showInputDialog("Nome do funcionario comissionado"), JOptionPane.showInputDialog("Numero de BI do funcionario comissionado"), JOptionPane.showInputDialog("Estado Civil do funcionario comissionado"), JOptionPane.showInputDialog("Data de nascimento do funcionario comissionado"), JOptionPane.showInputDialog("Morada do funcionario comissionado"), JOptionPane.showInputDialog("Nome do pai do funcionario comissionado"), JOptionPane.showInputDialog("Nome da mae do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), JOptionPane.showInputDialog("Sexo do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Altura do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem de vendas do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado")));

    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario() {
        System.out.println("Funcionarios Comissionarios");
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof Func_comissionado) {
                System.out.println(funcionarios[i].toString());
            }
        }
    }

    //metodo para adicionar funcionario produtividade
    public static void addFuncprodutividade() {
        funcionarios[1] = new Func_produtividade(JOptionPane.showInputDialog("Nome do funcionario produtividade"), JOptionPane.showInputDialog("Numero de BI do funcionario produtividade"), JOptionPane.showInputDialog("Estado civil do funcionario produtividade"), JOptionPane.showInputDialog("Data de nascimento do funcionario produtividade"), JOptionPane.showInputDialog("Moarada do funcionario produtividade"), JOptionPane.showInputDialog("Nome do pai do funcionario produtividade"), JOptionPane.showInputDialog("Nome da mae do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), JOptionPane.showInputDialog("Sexo do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Altura do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor por unidade produzido pelo funcionario produtividade")));

    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncProdutividade() {
        System.out.println("Funcionarios Produtividade");
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof Func_produtividade) {
                System.out.println(funcionarios[i].toString());
            }
        }
    }
    
    public static void printSalarioComissionado(){
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof Func_comissionado) {
                System.out.println(funcionarios[i].calcularRemuneracao());
            }
            
        }
    }
    
    public static  void printFuncionario(){
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i].toString());
            
        }
    }

    //metodo para listar a informa????o de todos funcion??rios 
    //registados pela ordem crescente do seu sal??rio.
    public static void listOrdem() {
        //nao consegui
    }

    public static void main(String[] args) {
        int menu = 0, sub_menu = 0, opcao = 0;

        menu = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario 3- Listar Funcionarios\n0 - Sair"));

        if (menu == 1) {
            sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Registar 2 Funcion??rios Comissionados\n2 - Registar 2 Funcion??rio Produtividade\n0 - Sair"));
            if (sub_menu == 1) {
                //metodo para registar 2 funcionarios comissionados
                for (int i = 0; i < 2; i++) {
                    JOptionPane.showMessageDialog(null, "Digite dados do " + (i + 1) + "o funcionario");
                    //adicionando o metodo que adiciona um comissionario
                    addFuncComissionado();

                    //metodo para mostar os funcionarios inseridos - para teste
                    System.out.println("");
                    listFuncComissionario();
                }

            } else if (sub_menu == 2) {
                //metodo para registar 2 funcionarios produtividade
                for (int i = 0; i < 2; i++) {
                    JOptionPane.showMessageDialog(null, "Digite dados do " + (i + 1) + "o funcionario");
                    //adicionando o metodo que adiciona um produtividade
                    addFuncprodutividade();

                    //metodo para mostar os funcionarios inseridos - para teste
                    System.out.println("");
                    listFuncProdutividade();

                }

            } else if (sub_menu == 0) {
                //caixa que pergunta se quer sair do sistema
                opcao = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                //verificando a escolha do usuario e fazendo a devida manipulacao
                if (opcao == 0) {
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "########");    //nao sei como fazer para voltar
                }
            }

        } else if (menu == 2) {
            sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Calcular salario do funcionario comissionado\n2 - Calcular salario funcion??rio produtividade\n0 - Sair"));
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
