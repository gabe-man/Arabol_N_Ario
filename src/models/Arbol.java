package models;

import java.util.ArrayList;

public class Arbol {
	private Nodo raiz;

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	public Nodo buscar(String valor) {
		return this.raiz.busca(valor);
	}
	
	public void insertarNodo(Nodo padre, String valor) {
		this.raiz.insertarNodo(padre, valor);
	}
	
	public String path(String valor)
	{
		String pathreverso = this.raiz.path(valor);
		String[] partes = pathreverso.split(",");
		
		String path="";
		
		for (int i = 0; i < partes.length; i++) {
			path = path+partes[partes.length-(i+1)]+"/";
		}
		
		return path;
	}
	
	public void mostrarArbol()
	{
		ArrayList<Nodo> listaNodos = new ArrayList<>();
		listaNodos = this.raiz.guardarNodos(raiz, listaNodos);
		
		for (int i = 0; i < listaNodos.size(); i++) {
			System.out.println(path(listaNodos.get(i).getValor()));
		}
	}
	/*
	public int nivel(Nodo nodobuscado) {
		return this.raiz.nivel(nodobuscado);
	}
	*/
}
