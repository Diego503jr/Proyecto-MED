/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verificarparentesis;

/**
 *
 * @author Diego Carías
 */
public class Pilas {

    private String parentesisAbierto[];
    private int cima;

    public Pilas(int cap) {
        parentesisAbierto = new String[cap];
        this.cima += -1;
    }

    public void push(String parenthesis) {
        parentesisAbierto[++cima] = parenthesis;
    }

    public String pop() {
        if (isEMpty()) {
            System.out.println("La pila esta vacia.");
        }
        return parentesisAbierto[cima--];
    }

    public boolean isEMpty() {
        return cima == -1;
    }
}
