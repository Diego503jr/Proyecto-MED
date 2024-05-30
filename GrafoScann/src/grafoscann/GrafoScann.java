/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafoscann;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Fernando Enrique Bermudez Torres
 */
public class GrafoScann {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo(0);
        int numVer, numAris, aristaOrigen, aristaDestion, menu, numAriReco = 0;
        Scanner in = new Scanner(System.in);
        boolean salir = true;

        while (salir) {
            try {
                System.out.println("\n  === MENU ===");
                System.out.println("1. Grafo Dirigido");
                System.out.println("2. Grafo No Dirigido");
                System.out.println("3. Imprimir datos");
                System.out.println("4. Matriz de Adyacencia");
                System.out.println("5. Busqueda Profunda");
                System.out.println("6. Busqueda Anchura");
                System.out.println("7. Algoritmo Dijkstra");
                System.out.println("8. Salir");
                System.out.print("Ingrese opcion: ");
                menu = in.nextInt();

                switch (menu) {
                    case 1:
                        System.out.print("Cuantos nodos desea ingresar?: ");
                        numVer = in.nextInt();

                        grafo = new Grafo(numVer);

                        System.out.print("Cuantas aristas hay? ");
                        numAris = in.nextInt();

                        for (int i = 0; i < numAris; i++) {
                            System.out.print("\nIngrese el numero del nodo (Origen): ");
                            aristaOrigen = in.nextInt();

                            System.out.print("Ingrese el numero del nodo (Destino): ");
                            aristaDestion = in.nextInt();

                            grafo.agregarAristaDirigida(aristaOrigen, aristaDestion);
                        }
                        break;
                    case 2:
                        System.out.print("\nCuantos nodos desea ingresar?: ");
                        numVer = in.nextInt();

                        grafo = new Grafo(numVer);

                        System.out.print("\nCuantas aristas hay?: ");
                        numAris = in.nextInt();

                        for (int i = 0; i < numAris; i++) {
                            System.out.print("\nIngrese el numero de nodo (Origen): ");
                            aristaOrigen = in.nextInt();

                            System.out.print("Ingrese el numero del nodo (Destino): ");
                            aristaDestion = in.nextInt();

                            grafo.agregarAristaNoDirigida(aristaOrigen, aristaDestion);

                        }
                        break;
                    case 3:
                        if (!grafo.isEmpty()) {
                            grafo.imprimirGrafo();
                        } else {
                            System.out.println("\nEl grafo esta vacio, no se puede recorrer");
                        }
                        break;
                    case 4:
                        if (!grafo.isEmpty()) {
                            grafo.matrizAdyacencia();
                        } else {
                            System.out.println("\nEl grafo esta vacio, no se puede recorrer");
                        }
                        break;
                    case 5:
                        if (!grafo.isEmpty()) {
                            System.out.print("Ingrese el vertice origen: ");
                            numVer = in.nextInt();
                            grafo.BusquedaProfundidad(numVer);
                        } else {
                            System.out.println("El grafo está vacío, no se puede recorrer\n");
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese el vértice de inicio para la búsqueda en anchura: ");
                        int verticeInicial = in.nextInt();
                        System.out.println("Búsqueda en Anchura empezando desde el vértice " + verticeInicial + ":");
                        grafo.busquedaEnAnchura(verticeInicial);
                        break;
                    case 7:

                        break;
                    case 8:
                        salir = false;
                        break;
                    default:
                        System.out.println("\nIngrese opcion correcta.");
                        break;
                }
            } catch (IndexOutOfBoundsException iOOBE) {
                System.out.println("Indice fuera de rango");
                in.nextLine();
            } catch (InputMismatchException iME) {
                System.out.println("Verifique que todo este bien.");
                in.nextLine();
            }
        }

        in.close();
    }

    private static void realizarRecorridoDijkstra() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de vertices:");
        int numVertices = scanner.nextInt();
        Grafo grafo = new Grafo(numVertices);

        System.out.print("Ingrese el numero de aristas:");
        int numAristas = scanner.nextInt();

        System.out.println("==Ingrese las aristas==");

        for (int i = 0; i < numAristas; i++) {
            System.out.println("Arista " + (i + 1) + ":");
            System.out.print("Ingrese el origen:");
            int origen = scanner.nextInt();
            System.out.print("Ingrese el destino:");
            int destino = scanner.nextInt();
            grafo.agregarAristaDirigida(origen, destino);
        }

        grafo.imprimirGrafo(); // Imprime la representación del grafo

        System.out.print("Ingrese el nodo de inicio para encontrar el camino minimo: ");
        int inicio = scanner.nextInt();

        //con dijkstra llama al metodo desde el nodo del inicio
        ((Grafo) grafo).recorridoMinimoDijkstra(inicio); // Realiza el recorrido mínimo de Dijkstra
    }

}
