
/**
 *
 * @author Fernando Gomes
 */
public class RecursosHumanos {

    public static Colaborador[] colaboradores = new Colaborador[3];

    public static void addAdministrador() {
        colaboradores[0] = new Administrador("Fernando Gomes Administrador", "Matola", "870357939", 3, 15000, 0.1, 2000);
    }

    public static void listaAdministrador() {
        //impressao dos administradores
        System.out.println("\nAdministradores");
        for (int i = 0; i < colaboradores.length; i++) {
            if (colaboradores[i] instanceof Administrador) {
                System.out.println(colaboradores[i].toString()
                );
            }

        }

    }

    public static void addOperario() {
        colaboradores[1] = new Operario("Fernando Gomes Operario", "Gaza", "8412345678", 4, 3000, 0.1, 1000, 0.05);
    }

    public static void listaOperario() {
        System.out.println("\nOperarios");
        for (int i = 0; i < colaboradores.length; i++) {
            if (colaboradores[i] instanceof Operario) {
                System.out.println(colaboradores[i].toString()
                );
            }

        }
    }

    public static void addColaborador() {
        colaboradores[3] = new Colaborador("Fernando Gomes Colaborador", "Maputo", "840357939", 1, 5000, 0.1);

        //criando um colaborador
        System.out.println("Colaborador:");

        System.out.println(colaboradores[3].toString());
        System.out.println("O salario: " + colaboradores[3].calcularSalario() + "\n");

    }

    public static void main(String[] args) {
        addAdministrador();
        listaAdministrador();

        addOperario();
        listaOperario();

    }
}
