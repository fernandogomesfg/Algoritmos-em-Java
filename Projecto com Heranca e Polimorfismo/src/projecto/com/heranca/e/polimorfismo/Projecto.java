/***
 * Uso de Heranca e Polimorfismo em um projecto de loja com Balconista (vendedor) e o entregador (motorista). O vendedor tem salario e comissao de venda enquanto que o motorista tem salrio fixo. Os dois tem os mesmos arbutos: Nome,CPF e Telefone
 * Data:19/09/2021
 */
package projecto.com.heranca.e.polimorfismo;

/**
 *
 * @author Fernando Gomes
 */
public class Projecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("Fernando", "123", "84123456");
        v1.setSalario(800.0);
        v1.setComissao(10.5);
        v1.setQtd_Vendas(10);
        System.out.println(v1.getDados());
        
        Motorista m1 = new Motorista("Jose","0000", "214");
        m1.setSalario(800.0);
        System.out.println(m1.getDados());
    }
    
}
