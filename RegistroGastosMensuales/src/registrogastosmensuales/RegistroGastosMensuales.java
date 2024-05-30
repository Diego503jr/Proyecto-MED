/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrogastosmensuales;

import java.time.LocalDate; //Obtener fechas
import java.time.YearMonth; //Obtener cantidad de dias en el mes
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Sarai Villalta
 */
public class RegistroGastosMensuales {

    public static Scanner entrada = new Scanner(System.in); //Objeto Scanner para entradas por teclado

    public static double gastoTotal = 0, monto;
    public static int contGastos;
    public static ArrayList<String> descripciones = new ArrayList<>();
    public static ArrayList<Double> montos = new ArrayList<>();
    public static String descripcionGasto, opcion;

    //Obtenemos la  fecha actual
    public static LocalDate fecha = LocalDate.now();
    public static int dia = fecha.getDayOfMonth(), mes = fecha.getMonthValue(), año = fecha.getYear(); //Obtenemos dia/mes/año

    public static void main(String[] args) {

        do {
            try {
                //Este Do, se cumple mientras no haya cambio de mes

                System.out.println("Registro Mensual de gastos");

                System.out.println("\n\t" + dia + "/" + mes + "/" + año);
                Menu();
                if (opcion.equals("1")) {
                    System.out.print("Ingrese la descripcion del gasto: ");
                    descripcionGasto = entrada.nextLine().trim();  //Elimina espacios en blanco del inicio de la cadena

                    if (descripcionGasto.isEmpty()) {
                        break;
                    }
                    do {
                        System.out.print("Ingrese el monto: $");
                        monto = entrada.nextDouble();
                    } while (monto <= 0);//Verificamos que no sea menor que 0 
                    descripciones.add(descripcionGasto); //Agregramos la descripcion al ArrayList
                    montos.add(monto); //Agregramos el monto al ArrayList
                    System.out.println("Nuevo gasto registrado\n");
                    entrada.nextLine(); // Consumir el salto de línea pendiente
                } else if (opcion.equals("2")) {
                    Limpiar();
                    Impresiones();
                    System.out.println("\n\n");
                } else if (opcion.equals("3")) {
                    System.out.println("Gracias por utilizar el registro de gastos");
                } else {
                    throw new IllegalStateException("Opcion incorrecta\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Dato ingresado es incorrecto\n");
                entrada.nextLine();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                //entrada.nextLine();

            }
        } while (!opcion.equals("3")); //La condicion dejará de cumplirse mientras no sea ultimo mes y ultimo dia del año

    }

    //Métodos
    public static void Impresiones() {
        //Impresion de gastos 
        contGastos = descripciones.size();
        System.out.println("\n\nGastos Mensuales");
        System.out.println("Este mes tuvo " + contGastos + " gastos, detallados a continuacion:");
        for (int i = 0; i < contGastos; i++) {
            gastoTotal += montos.get(i);
            System.out.println("\nDescipcion del gasto: " + descripciones.get(i));
            System.out.println("Monto: $" + montos.get(i));
        }
        System.out.println("El total de sus gastos es de: $" + gastoTotal);
    }

    public static String Menu() {
        System.out.println("\n1.Ingresar nuevos gastos");
        System.out.println("2. Verificar gastos");
        System.out.println("3. Salir");
        System.out.print("Seleccione su opcion: ");
        opcion = entrada.nextLine();
        return opcion;
    }

    public static void Limpiar() {
        gastoTotal = 0;
        contGastos = 0;
    }

}
