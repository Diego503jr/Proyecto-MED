/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notacionfijaanotacionpolacainversa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Carías
 */
public class NotacionFijaANotacionPolacaInversa extends Thread {

    private static ArrayList<String> polacaInversa;
    private static String notacionInfija;
    private static Pila pila;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        boolean salir = true;

        while (salir) {
            try {
                System.out.println("\n    == Menu ==");
                System.out.println("1.Conversion de notacion infija a polaca inversa");
                System.out.println("2.Salir");
                System.out.print("Ingrese una opcion: ");
                menu = input.nextInt();

                input.nextLine();
                switch (menu) {
                    case 1:
                        System.out.print("\nIngrese la notacion infija: ");
                        notacionInfija = input.nextLine();

                        infijaToPolacaInversa(notacionInfija, polacaInversa);

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
    }

    private static void infijaToPolacaInversa(String notacionInfija, ArrayList<String> polacaInversa) {
        polacaInversa = new ArrayList<>();
        pila = new Pila();

        for (int i = 0; i < notacionInfija.length(); i++) {
            char caracter = notacionInfija.charAt(i);

            if (Character.isDigit(caracter)) {
                polacaInversa.add(String.valueOf(caracter));
            } else if (caracter == '(') {
                pila.push(String.valueOf(caracter));
            } else if (caracter == '/' || caracter == '*' || caracter == '-' || caracter == '+') {
                if (pila.isEmpty()) {
                    pila.push(String.valueOf(caracter));
                } else {
                    while (!pila.isEmpty() && operadores(caracter) <= operadores(pila.peek().charAt(0))) {
                        polacaInversa.add(pila.pop());
                    }
                    pila.push(String.valueOf(caracter));
                }
            } else if (caracter == ')') {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    polacaInversa.add(pila.pop());
                }
                if (!pila.isEmpty() && pila.peek().equals("(")) {
                    pila.pop();
                } else {
                    pila.push(String.valueOf(caracter));
                    System.out.println("\nError! No se encontro parentesis de apertura correspondiente.");
                    break;
                }
            }
        }
        
        while (!pila.isEmpty() && !pila.peek().equals(")") && !pila.peek().equals("(")) {
            polacaInversa.add(pila.pop());
        }

        if (pila.isEmpty()) {
            System.out.print("\nBalanceando a notacion Polaca inversa");
            cargador();

            System.out.print("\nNotacion polaca inversa: ");
            for (String elementos : polacaInversa) {
                System.out.print(elementos);
            }

            System.out.print("\nNotacion infija: " + notacionInfija);
        } else {
            System.out.println("\nLa expresion no esta balanceada");
        }

    }

    private static int operadores(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static void cargador() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException ex) {
                System.out.println("Error! funcion interrumpida.");
            } catch (Exception e) {
                System.out.println("Error! el cargador no funciona.");
            }
        }
        System.out.println("");
    }

}
