/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertircadena;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sarai Villalta
 */
public class InvertirCadena {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String cadena;
        int longitud, opcion;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("1. Ingresar palabra");
                System.out.println("2. Salir");
                System.out.print("Opción: ");
                opcion = entrada.nextInt();
                entrada.nextLine();
                if (opcion == 1) {
                    System.out.print("Ingrese la palabra: ");
                    cadena = entrada.nextLine();

                    longitud = cadena.length();

                    Invertir invertir = new Invertir(longitud);

                    invertir.push(cadena);
                    invertir.pop();
                    invertir.imprimir();
                } else if (opcion == 2) {
                    continuar = false;
                } else {
                    System.out.println("\nOpcion incorrecta\n");
                    continuar = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpcion incorrecta\n");
                continuar = true;
                entrada.nextLine();
            }
        }

    }

}
