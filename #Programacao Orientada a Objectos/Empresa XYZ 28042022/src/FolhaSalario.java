
import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author Fernando Gomes
 */
import java.util.*;

public class FolhaSalario {

    //arraylist de funcionarios
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    //metodo para adicionar funcionario comissionado
    public static void addFuncComissionado() {
        
        try {
            
            //Carrega o arquivo
            FileInputStream folha_salario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folha_salario);
            funcionarios = (ArrayList) objLeitura.readObject();
            funcionarios.add(new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado"))));
            
                //Gera o arquivo para armazenar o objeto
            FileOutputStream folhasalario
                    = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            System.out.println("Objeto gravado com sucesso!");
            
            
        } catch (Exception ex) {
            try {
                //Gera o arquivo para armazenar o objeto se nao existir
            FileOutputStream folhasalario
                    = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            
            funcionarios.add(new FuncComissionado(JOptionPane.showInputDialog("Numero do BI do funcionario comissionado"), JOptionPane.showInputDialog("Data de ingresso do funcionario comissionado"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario comissionado")), Double.parseDouble(JOptionPane.showInputDialog("Percentagem do funcionario comissionado")), Integer.parseInt(JOptionPane.showInputDialog("Numero de vendas do funcionario comissionado"))));
            
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            System.out.println("Objeto gravado com sucesso!");
            } catch (Exception e) {
                
            }
        }
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncComissionario() {
        try {
            //Carrega o arquivo
            FileInputStream folhasalario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folhasalario);
            funcionarios = (ArrayList) objLeitura.readObject();

            System.out.println("Funcionarios Comissionarios");
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i) instanceof FuncComissionado) {
                    System.out.println(funcionarios.get(i).toString());
                }

            }

            objLeitura.close();
            folhasalario.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo para imprimir salario do funcionario comissionado
    public static void printSalarioComissionado() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i) instanceof FuncComissionado) {
                System.out.println(funcionarios.get(i).calcularRemuneracao());
            }

        }
    }

    //metodo para adicionar funcionario produtividade
    public static void addFuncprodutividade() {
        funcionarios.add(new FuncProdutividade(JOptionPane.showInputDialog("Numero do BI do funcionario produtividade"), JOptionPane.showInputDialog("Data de ingresso do funcionario produtividade"), Double.parseDouble(JOptionPane.showInputDialog("Salario do funcionario produtividade")), Integer.parseInt(JOptionPane.showInputDialog("Unidade produzida do funcionario produtividade")), Double.parseDouble(JOptionPane.showInputDialog("Valor da unidade produzida funcionario produtividade"))));

        try {
            //Gera o arquivo para armazenar o objeto
            FileOutputStream folhasalario
                    = new FileOutputStream("folhasalario.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(folhasalario);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(funcionarios);
            objGravar.flush();
            objGravar.close();
            folhasalario.flush();
            folhasalario.close();
            System.out.println("Objeto gravado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo para listar funcionarios comissionarios
    public static void listFuncProdutividade() {
        try
        {
            //Carrega o arquivo
            FileInputStream folhasalario = new FileInputStream("folhasalario.dat");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(folhasalario);
            funcionarios = (ArrayList) objLeitura.readObject();

            System.out.println("Funcionarios Comissionarios");
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i) instanceof FuncProdutividade) {
                    System.out.println(funcionarios.get(i).toString());
                }

            }

            objLeitura.close();
            folhasalario.close();
        }
        catch(Exception e) {
    	      e.printStackTrace();
    	    }

    }

    //metodo para imprimir salario do funcionario produtividade
    public static void printSalarioProdutividade() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i) instanceof FuncProdutividade) {
                System.out.println(funcionarios.get(i).calcularRemuneracao());
            }

        }
    }

    /*metodo para listar a informação de todos funcionários 
    registados pela ordem crescente do seu salário.
    Para tal devem ir investigar sobre a interface COMPARABLE e o metodo Sort da interface Collections
     */
    public static void listOrdem() {
        //nao consegui
    }

    public static void main(String[] args) {
        /* int menu = 0, sub_menu = 0, opcao = 0;

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
         */
        addFuncComissionado();
        listFuncComissionario();
        //System.out.println(" ");
        //listFuncProdutividade();
        //addFuncComissionado();
        //addFuncprodutividade();
    }
}
