
package enteroromano;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author noefdo.solismay
 */
public class EnteroRomano {

    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int numero=0;

        do{
            System.out.println("Introduce un múmero entero entre 1 y 1000 : ");
            try{                                                             //Captura posible error de escritura de alguna letra
                numero=scanner.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("¡Solo se pueden digitar números enteros!... ");
                scanner.next();                                             // Retorna la a captura ignorando el valor de letra

            }
        } while (numero<1 || numero > 1000);                                // número entre 1 y 1000
        System.out.println("El " + numero + " en numeración romana es: " + convierteARomanos(numero));
    }
    public static String convierteARomanos(int numero1){
        int i, unidad, decena, centena, millar;
        String enRomano="";

        //Descompone el número en cifras
        unidad = numero1 % 10; numero1 /= 10; //unidades
        decena = numero1 % 10; numero1 /= 10; //decenas
        centena = numero1 % 10; numero1 /= 10; //centenas
        millar = numero1 % 10 ; numero1 /= 10; //millar

        if (millar == 1){
            enRomano=enRomano+"M";
        }
        //centenas
        if (centena == 9) {
            enRomano = enRomano + "CM";
        } else if (centena >= 5) {
            enRomano = enRomano + "D";
            for (i = 6; i <= centena; i++) {
                enRomano = enRomano + "C";
            }
        } else if (centena == 4) {
            enRomano = enRomano + "CD";
        } else {
            for (i = 1; i <= centena; i++) {
                enRomano = enRomano + "C";
            }
        }

        //decenas
        if (decena == 9) {
            enRomano = enRomano + "XC";
        } else if (decena >= 5) {
            enRomano = enRomano + "L";
            for (i = 6; i <= decena; i++) {
                enRomano = enRomano + "X";
            }
        } else if (decena == 4) {
            enRomano = enRomano + "XL";
        } else {
            for (i = 1; i <= decena; i++) {
                enRomano = enRomano + "X";
            }
        }

        //unidades
        if (unidad == 9) {
            enRomano = enRomano + "IX";
        } else if (unidad >= 5) {
            enRomano = enRomano + "V";
            for (i = 6; i <= unidad; i++) {
                enRomano = enRomano + "I";
            }
        } else if (unidad == 4) {
            enRomano = enRomano + "IV";
        } else {
            for (i = 1; i <= unidad; i++) {
                enRomano = enRomano + "I";
            }
        }

        return enRomano;                //Devuelve en número en romano
    }
}
