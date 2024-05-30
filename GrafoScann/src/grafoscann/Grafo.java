/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoscann;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Diego Carías
 */
public class Grafo {

    private int numVertices;
    private LinkedList<Integer> listAdyacencia[];

    public Grafo(int vertices) {
        this.numVertices = vertices;
        listAdyacencia = new LinkedList[vertices];

        /**
         * Se inicializa una nueva instancia 'cada vertice' se crea una
         * LinkedList vacia
         */
        for (int i = 0; i < vertices; ++i) {
            listAdyacencia[i] = new LinkedList<>();
        }
    }

    //Metodo para agregar una arista no dirigida
    public void agregarAristaNoDirigida(int origen, int destino) {
        if (!listAdyacencia[origen].contains(destino) && !listAdyacencia[destino].contains(origen)) {
            //Aqui que sera unidireccional
            listAdyacencia[origen].add(destino);
            //Aqui le estamos diciendo que sera bidireccional
            listAdyacencia[destino].add(origen);
            System.out.println("\nSe agrego correctamente");
        } else {
            System.out.println("\nYa existe un registro");
        }
    }

    //Metodo para agregar una arista dirigida
    public void agregarAristaDirigida(int origen, int destino) {
        //Aqui que sera unidireccional
        if (!listAdyacencia[origen].contains(destino)) {
            listAdyacencia[origen].add(destino);
            System.out.println("\nAgregado!!");
        } else {
            System.out.println("\nYa existe un registro");
        }
    }

    //Impresion de grafos dirigidos y no dirigidos
    public void imprimirGrafo() {
        System.out.println("\n");
        for (int i = 0; i < numVertices; ++i) {
            System.out.print("Nodo " + i + "");
            for (int nodo : listAdyacencia[i]) {
                System.out.print(" -> " + nodo);
            }
            System.out.println(" ");
        }
    }

    // Busqueda en profundidad recursivo
    private void BusquedaProfundidadRec(int vertice, boolean[] recorridos) {
        // Marcar el nodo actual como recorrido e imprimir
        recorridos[vertice] = true;
        System.out.print(vertice + " ");

        // Verifica todos los vértices adyacentes a este vértice
        for (int adyacente : listAdyacencia[vertice]) {
            if (!recorridos[adyacente]) {
                BusquedaProfundidadRec(adyacente, recorridos);
            }
        }
    }

    // Busqueda en profundidad
    public void BusquedaProfundidad(int verticeInicial) {
        System.out.print("\n    --- Recorrido en profundidad --- ");
        // Crear un array para seguir los vértices ya expandidos
        boolean[] recorridos = new boolean[numVertices];

        // Método recursivo
        BusquedaProfundidadRec(verticeInicial, recorridos);
        System.out.println();
    }

    // Metodo para realizar BFS
    void busquedaEnAnchura(int verticeInicial) {
        boolean[] visitado = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();

        visitado[verticeInicial] = true;
        cola.add(verticeInicial);

        while (!cola.isEmpty()) {
            int vertice = cola.poll();
            System.out.print(vertice + " ");

            for (int adyacente : listAdyacencia[vertice]) {
                if (!visitado[adyacente]) {
                    visitado[adyacente] = true;
                    cola.add(adyacente);
                }
            }
        }
        System.out.println();
    }

    public void matrizAdyacencia() {
        System.out.println("\n  --- Matriz de Adyacencia ---");
        //Crear un arreglo bidimensional para almacenar las aristas
        int[][] adyaMatriz = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            //Se declara una lista para almacenarla en ella los vecinos
            List<Integer> vecinos = listAdyacencia[i];
            for (Integer vecino : vecinos) {
                //Se agregan los vecinos que encuentra al arreglo
                adyaMatriz[i][vecino] = 1;
                adyaMatriz[vecino][i] = 1;
            }
        }

        //Se reccorre el numero de vertices dos veces
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                //Mostrar de manera sencilla el arreglo 
                System.out.print(adyaMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void recorridoMinimoDijkstra(int origen) {
        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();
        Map<Integer, Integer> distancia = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            distancia.put(i, Integer.MAX_VALUE);
        }
        distancia.put(origen, 0);
        colaPrioridad.add(origen);

        while (!colaPrioridad.isEmpty()) {
            int nodoActual = colaPrioridad.poll();
            for (int vecino : listAdyacencia[nodoActual]) {
                int nuevaDistancia = distancia.get(nodoActual) + 1;
                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    colaPrioridad.add(vecino);
                }
            }
        }

        System.out.println("Recorrido minimo desde el nodo " + origen + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Distancia al nodo " + i + ": " + distancia.get(i));
        }
    }

    //Metodo para comprobar si esta vacio el grafo
    public boolean isEmpty() {
        return numVertices == 0;
    }
}
