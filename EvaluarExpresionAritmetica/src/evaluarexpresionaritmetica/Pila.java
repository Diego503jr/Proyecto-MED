package evaluarexpresionaritmetica;
/*
 * @Autor: Ulises Rivera Guill�n
 */

public class Pila {
	private double[] elementos;
	private int cima;
	private int capacidad;
	
	public Pila(int capacidad) {
		this.capacidad = capacidad;
		this.elementos = new double[capacidad];
		this.cima = -1;
	}
	
	//Metodo Push para agregar elementos
	public void push(double elemento) {
		elementos[++cima] = elemento;
	}
	
	//Metodo Pop para extraer elementos
	// M�todo Pop para extraer elementos
	public double pop() {
	    if(isEmpty()) {
	        System.out.println("Error: La pila est� vac�a");
	        return Double.NaN; // Devuelve un valor no v�lido para indicar un error
	    }
	    return elementos[cima--]; // Decrementa cima despu�s de devolver el elemento
	}

	
	//Metodo IsEmpty para saber si esta vacio
	public boolean isEmpty() {
		return cima == -1;
	}
	
	//Metodo Size para saber el tama�o
	public int size() {
		return cima+1;
	}
	
}