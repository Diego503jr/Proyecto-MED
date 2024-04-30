package registronotas;

import java.util.Scanner;

/*
 * @Autor: Ulises Rivera Guillén
 */
public class RegistroNotas {
    //Crear un programa que permita ingresar calificaciones de
    //varios estudiantes; mostrar el promedio de las calificaciones
    //la nota mas alta y la mas baja

    public static void main(String[] args) {
        //Declaramos el objeto Scanner
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                //Solicitamos que ingrese la cantidad notas totales
                System.out.print("Ingrese la cantidad de notas a ingresar: ");
                int cantidadNotas = input.nextInt();

                //En base a la cantidad usamos un For para ingresar las notas al arreglo
                double[] notas = new double[cantidadNotas];

                for (int i = 0; i < cantidadNotas; i++) {
                    double nota;
                    do {
                        System.out.print("Ingrese la nota " + (i + 1) + ": ");
                        nota = input.nextDouble();
                        if (nota < 0 || nota > 10) {
                            System.out.println("ERROR: La nota debe estar entre 0 y 10. Intente de nuevo.");
                        }
                    } while (nota < 0 || nota > 10);

                    notas[i] = nota;
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
                System.out.println("\nLa cantida de notas ingresada fue de: " + cantidadNotas);
                System.out.println("El promedio obtenido fue de: " + promedio);
                System.out.println("La nota maxima ingresada fue de: " + maximo);
                System.out.println("La nota minima ingresada fue de: " + minimo);

                break;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("ERROR: Ingreso un valor no permitido");
            }
        }
    }
}
