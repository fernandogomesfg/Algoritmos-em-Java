
/**
 *
 * @author Fernando Gomes
 */
public class RecursosHumanos {

    public static void main(String[] args) {

        //criando um colaborador
        System.out.println("Colaborador:");
        Colaborador fernando = new Colaborador("Fernando Gomes Colaborador", "Maputo", "840357939", 1, 5000, 0.1);
        System.out.println(fernando.toString());
        System.out.println("O salario: " + fernando.calcularSalario() + "\n");

        //criando um administrador
        System.out.println("Administrador:");
        Colaborador admin = new Administrador("Fernando Gomes Administrador", "Matola", "870357939", 3, 15000, 0.1, 2000);
        System.out.println(admin.toString());
        System.out.println("O salario do Administrador: " + admin.calcularSalario() + "\n");

        //criando um operario
        System.out.println("Operario:");
        Colaborador operario = new Operario("Fernando Gomes Operario", "Gaza", "8412345678", 4, 3000, 0.1, 1000, 0.05);
        System.out.println(operario.toString());
        System.out.println("O salario do operario: " + operario.calcularSalario());
        System.out.println("");

        //criacao de um array de objectos da classe colaborador
        Colaborador[] colaboradores = new Colaborador[3];   
        colaboradores[0] = fernando;
        colaboradores[1] = admin;
        colaboradores[2] = operario;

        //impressao de todos colaboradores
        System.out.println("Impressao usando array");
        for (int i = 0; i < colaboradores.length; i++) {
            System.out.println(colaboradores[i].toString());
        }
        




    }
}
