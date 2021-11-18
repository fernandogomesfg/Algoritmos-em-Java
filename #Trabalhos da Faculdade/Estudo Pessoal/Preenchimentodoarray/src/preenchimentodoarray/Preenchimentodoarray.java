package preenchimentodoarray;

import java.util.Scanner;

public class Preenchimentodoarray {
    public static void main(String[] args) {
        Scanner teclado= new Scanner (System.in);
        String [] num= new String [5];
        
        for (int i=0; i<num.length; i++){
        // Prencimento do array
            System.out.print("Introduza o valor"+(i+1)+"=");
            num [i]=teclado.nextLine();
        //   
        }
    }
    
}
