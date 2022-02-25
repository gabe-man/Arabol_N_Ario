package mainapp;

import java.util.ArrayList;
import java.util.Arrays;

import models.Arbol;
import models.Nodo;

public class MainApp {
	public static void main(String[] args) {

		// HOJAS
		Nodo uno = new Nodo("uno");
		Nodo seis = new Nodo("seis");
		Nodo tres = new Nodo("tres");
		Nodo cuatro = new Nodo("cuatro");

		Nodo cinco = new Nodo("cinco", new ArrayList<Nodo>(Arrays.asList(seis)));
		Nodo dos = new Nodo("dos", new ArrayList<Nodo>(Arrays.asList(cinco)));

		Nodo pollo = new Nodo("pollo", new ArrayList<Nodo>(Arrays.asList(uno, dos)));
		Nodo cerdo = new Nodo("cerdo", new ArrayList<Nodo>(Arrays.asList(tres)));
		Nodo ternera = new Nodo("ternera", new ArrayList<Nodo>(Arrays.asList(cuatro)));
		
		Nodo raiz = new Nodo("~", new ArrayList<Nodo>(Arrays.asList(pollo, cerdo, ternera)));

		Arbol arbol = new Arbol(raiz);
		
		/*//Insertar un nodo
		arbol.insertarNodo(uno, "siete");
		
		System.out.println(arbol.buscar("siete"));
		*/
		
		System.out.println(arbol.path("cinco"));
		
		arbol.mostrarArbol();
		
	}
}
