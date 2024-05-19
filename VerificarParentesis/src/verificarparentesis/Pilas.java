/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verificarparentesis;

import java.util.ArrayList;

/**
 *
 * @author Diego Carías
 */
public class Pilas {

    private ArrayList<String> parentesisAbierto;
    private int cima;

    public Pilas() {
        parentesisAbierto = new ArrayList<>();
        this.cima += -1;
    }

    public void push(String parenthesis) {
        parentesisAbierto.add(parenthesis);
        cima++;
    }

    public String pop() {
        String elementoBorrar = peek();
        parentesisAbierto.remove(cima);
        cima--;
        return elementoBorrar;
    }

    public boolean isEmpty() {
        return cima == -1;
    }
    
    public String peek(){
        return parentesisAbierto.get(cima);
    }
}
