/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torredehanoi;

/**
 *
 * @author Sarai Villalta
 */
public class Pila {

    //Declaración de variables
    public int hanoi[][];
    public int cantidad;
    int discoSacado = 0;

    //Método constructor
    public Pila(int cantidad) {
        this.cantidad = cantidad;
    }

    //Inicialización del arreglo (Llenado)
    public void llenado() {
        int h = 1, i = 0;
        hanoi = new int[3][cantidad];
        while (i != cantidad) {
            hanoi[0][i] = h;
            hanoi[1][i] = 0;
            hanoi[2][i] = 0;
            i++;
            h++;
        }
        System.out.println("\n");
        for(int k = 0; k < cantidad ; k++){
            System.out.println(hanoi[0][k] + "    " + hanoi[1][k] + "    " + hanoi[2][k]);
        }
    }

    //Método para sacar un número de la pila
    public int pop(int torre) {
        for (int i = 0; i < hanoi[torre].length; i++) {
            if (hanoi[torre][i] != 0) {
                discoSacado = hanoi[torre][i];
                hanoi[torre][i] = 0;
                break;
            }
        }
        return discoSacado;
    }

    //Método para ingresar un número en una pila
    public void push(int torre) {
        for (int i = cantidad - 1; i >= 0; i--) {
            if (hanoi[torre][i] == 0) {
                hanoi[torre][i] = discoSacado;
                break;
            }
        }
    }

    //Mostrar la pila
    public void imprimir() {
        System.out.println("\n");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(hanoi[0][i] + "    " + hanoi[1][i] + "    " + hanoi[2][i]);
        }
    }

}
