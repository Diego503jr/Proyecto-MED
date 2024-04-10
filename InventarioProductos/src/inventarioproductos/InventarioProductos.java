/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventarioproductos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Diego Carías
 */
public class InventarioProductos {

    /**
     * Programa que simule un inventario de productos en una tienda
     */
    //Declaración de variables globales
    static double totalValorInventario = 0, valorProducto = 0;

    public static void main(String[] args) {
        //Declaración de variables locales
        int numProductos = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("    -----Bienvenidos al inventario de la tienda 'Mizata'    -----");

        while (true) {
            try {

                System.out.print("¿Cuantos productos desea Ingresar? ");
                numProductos = input.nextInt();

                String productos[][] = new String[numProductos][3];
                input.nextLine();

                for (int i = 0; i < numProductos; i++) {
                    System.out.print("\nIngrese el nombre del producto: ");
                    productos[i][0] = input.nextLine();

                    System.out.print("Ingrese el precio del producto: $ ");
                    productos[i][1] = String.valueOf(input.nextDouble());

                    System.out.print("Ingrese la cantidad disponible de los productos: ");
                    productos[i][2] = String.valueOf(input.nextInt());

                    input.nextLine();
                }

                //Mostrar datos del inventario
                mostrarInventario(productos);
                break;
            } catch (InputMismatchException iME) {
                System.out.println("Error!! Ingresa un número.");
                input.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("Error!! Verifica que todo este correcto.");
                input.nextLine();
                continue;
            }
        }
    }

    public static void mostrarInventario(String productos[][]) {
        //Impresion de datos
        System.out.println("\nInventario: ");
        System.out.println("-".repeat(40));
        System.out.printf("%-20s %-10s %-10s%n", "Nombre", "Precio", "Cantidad");
        System.out.println("-".repeat(40));

        for (String[] producto : productos) {
            String nombre = producto[0];
            double precio = Double.parseDouble(producto[1]);
            int cantidad = Integer.parseInt(producto[2]);

            //Obtencion del valor total del inventario
            valorProducto = precio * cantidad;
            totalValorInventario += valorProducto;

            System.out.printf("%-20s $ %-10f %-10d%n", nombre, precio, cantidad);
        }
        //Impresión del valor total del inventario
        System.out.printf("%nValor total del inventario: $%.2f%n", totalValorInventario);
    }

}
