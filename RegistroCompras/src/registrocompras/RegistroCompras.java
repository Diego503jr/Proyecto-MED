/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrocompras;

/**
 *
 * @author gisel
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroCompras {
    public static void main(String[] args) {
        //inicializamos Scanner para capturar datos del usuario por medio de teclado
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        //imprimimos un mensaje de bienvenida con el nombre solicitado
        System.out.println("\nHola, " + nombre + ". Bienvenido al programa de registro de compras");

        //inicializamos dos ArrayList para capturar el nombre y precio de los productos ingresados
        ArrayList<String> nombreProductos = new ArrayList<>();
        ArrayList<Double> precioProductos = new ArrayList<>();

        //utilizamos while para que el usuario ingrese la cantidad de productos hasta llegar al producto ya definido "fin"
        while (true) {
            System.out.print("\nIngrese el nombre del producto (escriba la palabra *fin* para finalizar): ");
            String producto = scanner.nextLine();
            if (producto.equalsIgnoreCase("fin")) {
                break;
            }

            double precio;
            double precioTotal;
            while (true) {
                try {
                    System.out.print("Ingrese el precio del producto: $ ");
                    precio = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese la cantidad de productos: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    
                    precioTotal = precio * cantidad;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: ingrese un valor numerico");
                    scanner.nextLine();
                }    
            }
            //se agregan los productos y los precios ingresados al ArrayList
            nombreProductos.add(producto);
            precioProductos.add(precioTotal);
        }

        //imprimimos todos los productos y precios ingresados en el ArrayList
        System.out.println("\nPRODUCTOS INGRESADOS:");
        for (int i = 0; i < nombreProductos.size(); i++) {
            //Se imprime el nombre de cada y el precio capturados en el bucle for de productos
            System.out.println(nombreProductos.get(i) + ": " + precioProductos.get(i));
        }

        //con ayuda de for-each mostramos el precio de los productos
        double total = 0;
        for (double precioTotal : precioProductos) {
            total += precioTotal;
        }
        //se imprime el precio total de todos los productos
        System.out.println("El precio total de todos los productos es de: " + total);
    }
}