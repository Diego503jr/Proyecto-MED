/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package invertircadena;

/**
 *
 * @author Sarai Villalta
 */
public class Invertir {
    int longitud;
    
    Character palabra[][];
    
    public Invertir(int longitud){
        this.longitud = longitud;
        palabra = new Character[2][longitud];
    }
    
    public void push(String cadena){
        for(int i = 0 ; i < longitud; i ++){
            palabra[0][i] = cadena.charAt(i);
        }
    }
    
    public void pop(){
        int j = 0;
        for(int i = longitud - 1; i >= 0; i--){
            palabra[1][j] = palabra[0][i];
            j++;
        }
    }
    
    public void imprimir(){
        System.out.print("\nPalabra ingresada: ");
        for(int i = 0; i < longitud; i ++){
            System.out.print(palabra[0][i]);
        }
        System.out.println("");
        tiempo();
        System.out.print("\nPalabra invertida: ");
        for(int i = 0 ; i < longitud; i++){
            System.out.print(palabra[1][i]);
        }
        System.out.println("\n");
    }
    
    public void tiempo() {
        System.out.print("\nInvirtiendo cadena ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000); // Espera de 2 segundos (2000 milisegundos)
                System.out.print(".");
            } catch (InterruptedException iE) {
                System.out.println("Error, ");
            } catch (Exception e) {
                System.out.println("");
            }
        }
    }
}
