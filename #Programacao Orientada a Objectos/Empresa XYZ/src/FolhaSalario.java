
import java.util.Scanner;
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
        funcionarios[0] = new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado")));
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario() {
        System.out.println("Funcionarios Comissionarios");
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof FuncComissionado) {
                System.out.println(funcionarios[i].toString());
            }

        }
    }

    //metodo para imprimir salario do funcionario comissionado
    public static void printSalarioComissionado() {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof FuncComissionado) {
                System.out.println(funcionarios[i].calcularRemuneracao());
            }

        }
    }

    //metodo para adicionar funcionario produtividade
    public static void addFuncprodutividade() {
        funcionarios[1] = new FuncProdutividade(JOptionPane.showInputDialog("Numero do BI do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Unidade produzida do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor da unidade produzida funcionario produtividade")));
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncProdutividade() {
        System.out.println("Funcionarios Comissionarios");
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof FuncProdutividade) {
                System.out.println(funcionarios[i].toString());
            }

        }
    }

    //metodo para imprimir salario do funcionario produtividade
    public static void printSalarioProdutividade() {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] instanceof FuncProdutividade) {
                System.out.println(funcionarios[i].calcularRemuneracao());
            }

        }
    }

    //metodo para listar a informação de todos funcionários 
    //registados pela ordem crescente do seu salário.
    public static void listOrdem() {
        //nao consegui
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int menu = 0, sub_menu = 0, opcao = 0;
        
       /*
        System.out.println("MENU\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario 3- Listar Funcionarios\n0 - Sair\"");
        System.out.println("\nEscolha uma opcao");
        menu = teclado.nextInt();
        switch (menu) {
            case 1:
                System.out.println("SUBMENU\n1 - Registar 2 Funcionários Comissionados\n2 - Registar 2 Funcionário Produtividade\n0 - Sair");
                sub_menu = teclado.nextInt();
                switch (sub_menu) {
                    case 1:
                        
                        //metodo para registar 2 funcionarios comissionados
                        for (int i = 0; i < 2; i++) {
                            //System.out.println("Digite dados do " +(i + 1) +"o funcionario");
                            JOptionPane.showMessageDialog(null, "Digite dados do " + (i + 1) + "o funcionario");
                            //adicionando o metodo que adiciona um comissionario
                            addFuncComissionado();

                            //metodo para mostar os funcionarios inseridos - para teste
                            System.out.println("");
                            listFuncComissionario();
                        }
                            break;
                        
                        case 2:
                        break;
                    default:
                }
                break;
                    case 2:
                        // code block
                        break;
                    case 3:
                        break;

                    default:
                        System.out.println("Obrigado por usar o nosso sistema");

                }
        */

            
        
        menu = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Rigistar Funcionarios\n2 - Calcular Saldo do Funcionario 3- Listar Funcionarios\n0 - Sair"));

        if (menu == 1) {
            sub_menu = Integer.parseInt(JOptionPane.showInputDialog("SUBMENU\n1 - Registar 2 Funcionários Comissionados\n2 - Registar 2 Funcionário Produtividade\n0 - Sair"));
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
