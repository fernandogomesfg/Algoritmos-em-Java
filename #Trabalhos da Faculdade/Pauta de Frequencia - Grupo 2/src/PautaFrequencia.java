
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

            FileOutputStream pauta = new FileOutputStream("PautaFinalAM.txt");
            PrintWriter pr = new PrintWriter(pauta);

            //cada linha do ficheiro contendo  os  resultados  de  frequência  
            String linha = null;
            int cont_admi = 0, cont_excl = 0, cont_disp = 0;
            double media = 0, teste1, teste2, teste3;

            //Impressao do cabecalho da pauta final
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
            pr.println();
            pr.println("Número" + "\t\t" + "Nome do Estudante" + "\t" + "Média" + "\t" + "Classificação");

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

                        //quebrando as notas para armazenar num array
                        String[] notas = testes.split("	");

                        for (int i = 0; i < notas.length; i++) {
                            //Colocando cada nota de cada estudante dentro 
                            //da variveis teste
                            teste1 = Double.parseDouble(notas[0]);
                            teste2 = Double.parseDouble(notas[1]);
                            teste3 = Double.parseDouble(notas[2]);

                            //Calculo da media
                            media = (0.4 * ((teste1 + teste2) / 2) + (teste3 * 0.6));

                        }

                        //array de classificacao
                        String[] classificacoes = {"Excluido", "Admitido", "Dispensado"};
                        String classificacao = null;

                        //Calculo da classificacao
                        if (media < 10) {
                            classificacao = classificacoes[0];
                            cont_excl = cont_excl + 1;
                        } else if (media >= 10 && media < 13.5) {
                            classificacao = classificacoes[1];
                            cont_admi = cont_admi + 1;
                        } else {
                            classificacao = classificacoes[2];
                            cont_disp = cont_disp + 1;
                        }

                        //Impressao da pauta, na parte das medias e classificacao
                        if (classificacao.equals(classificacoes[0])) {
                            pr.println(linha.substring(1, 24) + "\t\t" + media + "\t" + "EXCLUIDO");
                        } else if (classificacao.equals(classificacoes[1])) {
                            pr.println(linha.substring(1, 24) + "\t\t" + media + "\t" + "ADMITIDO");
                        } else {
                            pr.println(linha.substring(1, 24) + "\t\t" + media + "\t" + "DISPENSADO");
                        }

                    }

                }

            } while (linha != null);

            //Quantidade de alunos excluidos, admitidos dispensados
            pr.print("\n");
            pr.println("Quantidade  dos estudantes excluídos, admitidos e dispensados");
            pr.println("Admitidos: " + cont_admi);
            pr.println("Excluidos: " + cont_excl);
            pr.println("Dispensados: " + cont_disp);

            pr.close();
            pauta.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }

}
