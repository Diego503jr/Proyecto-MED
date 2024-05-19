/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notacionfijaanotacionpolacainversa;

import java.util.ArrayList;

/**
 *
 * @author Diego Carías
 */
public class Pila {

    private ArrayList<String> elementos;
    private int cima;

    public Pila() {
        elementos = new ArrayList<>();
        this.cima = -1; // Inicializa la cima en -1
    }

    public void push(String element) {
        elementos.add(element);
        cima++;
    }

    public String pop() {
        String elementoBorrar = peek();
        elementos.remove(cima);
        cima--;
        return elementoBorrar;
    }

    public boolean isEmpty() {
        return cima == -1;
    }

    public String peek() {
        return elementos.get(cima);
    }
}
