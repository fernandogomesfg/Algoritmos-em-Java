package fibo;
//importar o leitor de teclado
import java.util.Scanner;
public class Fibo {
//incializar a classe fibo com paramentro n
    static long fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int x;
        long  soma = 0;
        System.out.println("Digite um valor de x: ");
        x = teclado.nextInt();
        for (int i = 0; i < x; i++) {
            soma = soma + Fibo.fibo(i);
            System.out.println("(" + i + "):" + Fibo.fibo(i) + "\t");
        }
        System.out.println("A soma de"+ x +" elementos do Fibo = "+ soma);
    }
}
