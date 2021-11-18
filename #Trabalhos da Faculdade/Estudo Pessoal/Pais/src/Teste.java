
/**
 *
 * @author Fernando Gomes
 */
public class Teste extends Pais {

    public static void main(String[] args) {
        //Criando um objecto 'p1' com parametros de um pais
        Pais p1 = new Pais("Mocamique", "Maputo",123456 );
        
        //Criando um objecto 'p2' com parametros de um pais
        Pais p2 = new Pais("Malawi", "Lilongwe",1458 );
               
        //Imprimindo dados do pais um
        p1.imprimir();
        //p1.imprimir();
        //p2.imprimir();   

    }
    //Cotrutor da classe teste
    public Teste(String nome, String nome_da_capital, double dimensão) {
        super(nome, nome_da_capital, dimensão);
    }
    
}