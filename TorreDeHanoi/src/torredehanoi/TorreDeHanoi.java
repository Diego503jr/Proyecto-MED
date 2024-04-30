/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package torredehanoi;

import java.util.Scanner;

/**
 *
 * @author Sarai Villalta
 */
public class TorreDeHanoi {

    //Objeto pila de la clase Pila
    public static Pila pila = new Pila(0);
    public static int movimientos = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidadDiscos;

        System.out.print("Ingrese la cantidad de discos: ");
        cantidadDiscos = entrada.nextInt();

        pila = new Pila(cantidadDiscos);
        pila.llenado();
        movimientos(cantidadDiscos, 0, 1, 2); //Posicion representa las 3 torres
        System.out.println("\nJuego finalizado...");
        System.out.println("Cantidad de movimientos utilizados: " + movimientos);
    }

    public static void movimientos(int cantidad, int torreA, int torreB, int torreC) {
        int discoMovido;
        if (cantidad > 0) {
            movimientos(cantidad - 1, torreA, torreC, torreB);
            discoMovido = pila.pop(torreA);
            pila.push(torreC);
            movimientos++;
            pila.imprimir();
            movimientos(cantidad - 1, torreB, torreA, torreC);
        }
    }
}
