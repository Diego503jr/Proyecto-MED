/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioevaluado5;

import java.util.Scanner;

/**
 *
 * @author Diego Carías
 */
public class EjercicioEvaluado5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaramos el objeto Scanner
        Scanner input = new Scanner(System.in);

        //Solicitamos que ingrese la cantidad notas totales
        System.out.println("Ingrese la cantidad de notas a ingresar");
        int cantidadNotas = input.nextInt();

        //En base a la cantidad usamos un For para ingresar las notas al arreglo
        double[] notas = new double[cantidadNotas];

        for (int i = 0; i < cantidadNotas; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = input.nextDouble();
        }

        //Calculamos el promedio de las notas
        double sumaNotas = 0;
        for (int i = 0; i < notas.length; i++) {
            sumaNotas += notas[i];
        }
        double promedio = sumaNotas / cantidadNotas;

        //Calculamos la nota mas alta
        double maximo = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maximo) {
                maximo = notas[i];
            }
        }

        //Calculamos la nota mas baja
        double minimo = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < minimo) {
                minimo = notas[i];
            }
        }

        //Imprimimos los resultados
        System.out.println("La cantida de notas ingresada fue de: " + cantidadNotas);
        System.out.println("El promedio obtenido fue de: " + promedio);
        System.out.println("La nota maxima ingresada fue de: " + maximo);
        System.out.println("La nota minima ingresada fue de: " + minimo);

        input.close();

    }

}
