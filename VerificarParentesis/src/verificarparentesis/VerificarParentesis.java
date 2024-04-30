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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu, longExpresion;
        int numParentesisAbiertos = 0, numParentesisCerrados = 0;
        String expresion, parentesis = "(", expresionBalanceada = null;
        boolean salir = true;
        Pilas pilaParentesis = new Pilas(numParentesisAbiertos);

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

                        longExpresion = expresion.length();

                        for (int i = 0; i < longExpresion; i++) {
                            if (expresion.charAt(i) == '(') {
                                numParentesisAbiertos++;
                                pilaParentesis = new Pilas(numParentesisAbiertos);
                                pilaParentesis.push(parentesis);
                            }

                            if (expresion.charAt(i) == ')') {
                                numParentesisCerrados++;

                                while (!pilaParentesis.isEMpty()) {
                                    pilaParentesis.pop();
                                    numParentesisAbiertos--;
                                }
                            }
                        }

                        System.out.print("\nBalanceando expresion");
                        cargador();
                        if (numParentesisAbiertos < numParentesisCerrados) {
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
                }
            } catch (InputMismatchException iME) {
                System.out.println("\nError!! Ingresa un número.");
            } catch (Exception e) {
                System.out.println("\nError!! Verifica que todo este correcto.");
            }

        }
        input.close();
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
