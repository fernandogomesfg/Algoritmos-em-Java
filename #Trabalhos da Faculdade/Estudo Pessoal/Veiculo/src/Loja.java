
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Fernando Gomes
 */
public class Loja {

    //arraylist
    public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    //Crie e adicione no ArrayList duas bicicletas, três motorizadas e dois carros;
    public static void addCarro() {
        //duas bicicletas
        Veiculo bicicleta1 = new Bicicleta("marca", "modelo", "cor", 0);
        Veiculo bicicleta2 = new Bicicleta("marca", "modelo", "cor", 0);
        veiculos.add(bicicleta1);
        veiculos.add(bicicleta2);

        //três motorizadas
        Veiculo moto1 = new Motorizada("num_motor", "marca", "modelo", "cor", 1);
        Veiculo moto2 = new Motorizada("num_motor", "marca", "modelo", "cor", 1);
        Veiculo moto3 = new Motorizada("num_motor", "marca", "modelo", "cor", 1);
        veiculos.add(moto1);
        veiculos.add(moto2);
        veiculos.add(moto3);

        //dois carros
        Veiculo mazda = new Carro("1234", "Mazda", "ABC", "Blue", 1000);
        Veiculo toyota = new Carro("1234", "Mazda", "ABC", "Blue", 1000);
        veiculos.add(mazda);
        veiculos.add(toyota);

    }

    //Crie um método listarMotorizadas() que liste só e somente as motorizadas adicionadas no ArrayList
    public static void listarMotorizadas() {
        System.out.println("Lista de Motorizadas");
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i) instanceof Motorizada) {
                System.out.println(veiculos.get(i));
            }

        }
    }

    //Crie um método listarTodos() que lista todos veículos ordenadamente. Use
    //o método sort() da classe Collections para ordenar, e diga qual a ordem que a
    //listagem segue
    public static void listarTodos() {
        System.out.println("Lista de todos veiculos ordenadamente por ordem crescente dos precos");
        Collection.sort(ArrayList, new Comparable<veiculos>()){
        
    }
    };
    }

    //Crie um método procura() de busca, que permite pesquisar um veículo no ArrayList
    public static void procura() {
        System.out.println("Pesquisar um veículo no ArrayList");
    }
    
    public static int compareTo(){
        return Integer.compare(0, 0);
    }

    public static void main(String[] args) {
        addCarro();
        listarMotorizadas();
        listarTodos();
        procura();
        

}
