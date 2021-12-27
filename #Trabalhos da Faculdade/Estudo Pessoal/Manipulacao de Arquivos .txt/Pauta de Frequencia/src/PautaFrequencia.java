
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class PautaFrequencia {

    public static void main(String[] args) {

        try {
            //Lendo o ficheiro  contendo  os  resultados  de  frequência  
            FileInputStream arquivo = new FileInputStream("Pauta de Frequencia de AM.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            //cada linha do ficheiro contendo  os  resultados  de  frequência  
            String linha = null;
            int count_adm = 0, count_excl = 0, count_disp = 0;

            do {
                linha = br.readLine();

                if (linha != null) {
                    //Leitura dos dados e colocando em um array
                    if ((linha.contains("Disciplina:")) || (linha.contains("Ano lectivo:")) || (linha.contains("Semestre:")) || (linha.contains("Nome do Docente:"))) {
                        //Colocando os dados em um array
                        String[] dados = {linha};

                    }

                    //Assumindo que os numeros de estudantes iniciam com o ano de 
                    //ingresso do estudante (assuminos anos que iniciam com 1 e 2
                    if ((linha.startsWith("1")) || (linha.startsWith("2"))) {

                        //Variavel para armazenar as testes
                        String testes;
                        testes = (linha.substring(linha.length() - 17));
                        //System.out.println(testes);

                        String[] notas = testes.split("	");
                        System.out.println("\n");

                        double media = 0, teste1, teste2, teste3;
                        for (int i = 0; i < notas.length; i++) {
                            System.out.println("Nota " + (i + 1) + ": " + notas[i]);

                            teste1 = Double.parseDouble(notas[0]);
                            teste2 = Double.parseDouble(notas[1]);
                            teste3 = Double.parseDouble(notas[2]);

                            //Calculo da media
                            media = (0.4 * ((teste1 + teste2) / 2) + (teste3 * 0.6));

                        }

                        //array de classificacao
                        String[] classificacao = {"Excluido", "Admitido", "Dispensado"};

                        //impressao da media
                        System.out.println("Media: " + media);
                        //Calculo da classificacao
                        if (media < 10) {
                            //System.out.println(classificacao[0]);
                            count_excl = count_excl + 1;
                        } else if (media >= 10 && media < 14) {
                            //System.out.println(classificacao[1]);
                            count_adm = count_adm + 1;
                        } else {
                            //System.out.println(classificacao[2]);
                            count_disp = count_disp + 1;
                        }

                        //Quantidade de alunos excluidos, admitidos dispensados 
                        System.out.println("Quantidade de Admitidos: " + count_adm);
                        System.out.println("Quantidade de Excluidos: " + count_excl);
                        System.out.println("Quantidade de Dispensados: " + count_disp);

                    }
                    if ((linha.startsWith("1")) || (linha.startsWith("2"))) {
                        //Variavel para armazenar as testes
                        String num_nome;
                        num_nome = (linha.substring(1, 24));
                        String numero_nomes[] = num_nome.split("	");

                        for (int i = 0; i < numero_nomes.length; i++) {
                            System.out.println(numero_nomes[4]);

                        }

                        //Impressao do cabecalho da Pauta
                        FileOutputStream pauta = new FileOutputStream("PautaFinalAM.txt");
                        PrintWriter pr = new PrintWriter(pauta);

                        pr.println("UNIVERSIDADE EDUARDO MONDLANE\n"
                                + "FACULDADE DE CIENCIAS\n"
                                + "DEPARTAMENTO DE MATEMATICA E INFORMATICA\n"
                                + "\n"
                                + "Disciplina: Análise  Matemática\n"
                                + "Ano lectivo: 2021\n"
                                + "Semestre: Segundo Semestre\n"
                                + "Nome do Docente: Jose Joao\n"
                                + "\n"
                                + "Pauta final de Analise Matematica");

                        //Elaboracao da pauta final
                        pr.println(num_nome);

                        pr.close();
                        pauta.close();

                    }
                }

            } while (linha != null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o programa");

        }

    }

}
