/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventarioproductos;

import java.time.LocalDate;
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
    static double valorProducto = 0;
    static String productos[][] = new String[0][0];

    public static void main(String[] args) {
        //Declaración de variables locales
        int numProductos = 0, opcion;
        boolean salir = true;
        Scanner input = new Scanner(System.in);
        System.out.println("    -----Bienvenidos al inventario de la tienda 'MED'    -----");

        while (salir) {
            try {
                System.out.println("\n    ----- MENU -----");
                System.out.println("1. Agregar");
                System.out.println("2. Ver productos");
                System.out.println("3. Salir");
                System.out.print("Ingrese una opcion: ");
                opcion = input.nextInt();

                input.nextLine();

                switch (opcion) {
                    case 1:
                        //Agregar productos
                        System.out.println("\n ----- Agregar productos -----");
                        System.out.print("\n¿Cuantos productos desea Ingresar? ");
                        numProductos = input.nextInt();
                        input.nextLine();

                        String nuevoProductos[][] = new String[productos.length + numProductos][3];
                        System.arraycopy(productos, 0, nuevoProductos, 0, productos.length);

                        for (int i = productos.length; i < nuevoProductos.length; i++) {
                            System.out.print("\nIngrese el nombre del producto: ");
                            nuevoProductos[i][0] = input.nextLine();

                            System.out.print("Ingrese el precio del producto: $ ");
                            nuevoProductos[i][1] = String.valueOf(input.nextDouble());

                            System.out.print("Ingrese la cantidad disponible de los productos: ");
                            nuevoProductos[i][2] = String.valueOf(input.nextInt());

                            input.nextLine();
                            System.out.println("\n ----- Agregado! -----");
                        }

                        productos = nuevoProductos;
                        break;
                    case 2:
                        //Mostrar datos del inventario
                        if (productos.length != 0) {
                            System.out.println("\n  Inventario de productos: "+ LocalDate.now());
                            mostrarInventario(productos);
                        } else {
                            System.out.println("\n ----- El inventario esta vacio -----");
                        }
                        break;
                    case 3:
                        System.out.print("\n ----- Saliendo -----");
                        salir = false;
                    default:
                        System.out.println("\nPor favor ingrese una opcion correcta.");
                        break;
                }
            } catch (InputMismatchException iME) {
                System.out.println("\nError!! Ingresa un número.");
                input.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("\nError!! Verifica que todo este correcto.");
                input.nextLine();
                continue;
            }
        }
    }

    //Metodo para mostrar el inventario
    public static void mostrarInventario(String productos[][]) {
        double totalValorInventario = 0;
        //Impresion de datos
        System.out.println("-".repeat(40));
        System.out.printf("%-20s %-10s %-10s%n", "Nombre", "Precio", "Cantidad");
        System.out.println("-".repeat(40));

        //Recorriendo arreglo bidimensional con formatos
        for (String[] producto : productos) {
            String nombre = producto[0];
            double precio = Double.parseDouble(producto[1]);
            int cantidad = Integer.parseInt(producto[2]);

            //Obtencion del valor total del inventario
            valorProducto = precio * cantidad;
            totalValorInventario += valorProducto;

            System.out.printf("%-20s $ %-10s %-20d%n", nombre, precio, cantidad);
        }
        //Impresión del valor total del inventario
        System.out.printf("%nValor total del inventario: $%.2f%n", totalValorInventario,"$");
    }

}
