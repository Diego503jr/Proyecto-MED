/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package verificarparentesis;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Carías
 */
public class VerificarParentesis extends Thread {

    private static Pilas pilaParentesis;
    private static String expresion, expresionBalanceada;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        boolean salir = true;

        while (salir) {
            try {
                System.out.println("\n    === Menu ===");
                System.out.println("1. Agregar expresion.");
                System.out.println("2. Salir.");
                System.out.print("Ingrese una opcion: ");
                menu = input.nextInt();

                input.nextLine();
                switch (menu) {
                    case 1:
                        System.out.print("\nIngrese la expresion: ");
                        expresion = input.nextLine();

                        System.out.print("\nBalanceando expresion");
                        cargador();

                        if (verificarBalance(expresion)) {
                            expresionBalanceada = "Balanceada";
                        } else {
                            expresionBalanceada = "No Balanceada";
                        }

                        System.out.println("La expresion es '" + expresionBalanceada + "'");
                        break;
                    case 2:
                        System.out.print("\nSaliendo");
                        cargador();
                        salir = false;
                        break;
                    default:
                        System.out.println("\nError! por favor ingrese una opcion correcta");
                        break;
                }
            } catch (InputMismatchException iME) {
                System.out.println("\nError!! Ingresa un número.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("\nError!! Verifica que todo este correcto.");
                input.nextLine();
            }

        }
        input.close();
    }

    public static boolean verificarBalance(String expresion) {
        pilaParentesis = new Pilas();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == '(') {
                pilaParentesis.push(String.valueOf(caracter));
            } else if (caracter == ')') {
                if (pilaParentesis.isEmpty()) {
                    pilaParentesis.push(String.valueOf(caracter));
                } else {
                    pilaParentesis.pop();
                }
            }
        }
        return pilaParentesis.isEmpty();
    }

    public static void cargador() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException ex) {
                System.out.println("Error! funcion interrumpida.");
            } catch (Exception ex) {
                System.out.println("Error! el cargador no funciona.");
            }
        }
        System.out.println("");
    }
}
