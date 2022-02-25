package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private ArrayList<Nodo> hijos;
	private Nodo nodobuscado;
	private int contador=0;
	private int nivel=-1;
	
	public Nodo(String valor) {
		super();
		this.valor = valor;
		this.hijos = new ArrayList<>();
	}
	
	public Nodo(String valor, ArrayList<Nodo> hijos) {
		super();
		this.valor = valor;
		this.hijos = hijos;
		
	}

	public String getValor() {
		return valor;
	}

	public boolean esHoja() {
		return this.hijos.isEmpty();
	}
	
	public void preOrden(Nodo n) {		
		System.out.print(n.valor+",");
		
		for (int i = 0; i < hijos.size(); i++) {
			preOrden(hijos.get(i));
		}
	}	
	
	public void postOrden(Nodo n) {		
		
		for (int i = 0; i < hijos.size(); i++) {
			postOrden(hijos.get(i));
		}
		System.out.print(n.valor+",");
	}

	public Nodo busca(String valor) {
		if(this.valor.equals(valor))
		{
			return this;
		}
		else
		{
			for (int i = 0; i < hijos.size(); i++) {
				Nodo n = hijos.get(i).busca(valor);
				if(n != null)
				{
					return n;
				}
			}
			return null;
		}
	
	}
	
	public Nodo insertarNodo(Nodo padre, String valor) {
		if(this.valor.equals(padre.valor))
		{
			this.hijos.add(new Nodo(valor));
			return this;
		}
		else
		{
			for (int i = 0; i < hijos.size(); i++) {
				Nodo n = hijos.get(i).insertarNodo(padre, valor);
				if(n != null)
				{
					return n;
				}
			}
			return null;
		}
	}
	
	public String path(String valor) {
		if(this.valor.equals(valor))
		{
			return this.valor;
		}
		else
		{
			for (int i = 0; i < hijos.size(); i++) {
				String n = hijos.get(i).path(valor);
				if(n != null)
				{
					return (n+","+this.valor);
				}
			}
			return null;
		}
	}
	
	public ArrayList<Nodo> guardarNodos (Nodo n, ArrayList<Nodo> listaNodos)
	{
		listaNodos.add(n);
		for (int i = 0; i < n.hijos.size(); i++) {
			guardarNodos(n.hijos.get(i), listaNodos);
		}
		return listaNodos;
	}

	/*
	public int nivel(Nodo nodobuscado) {
		if(this.equals(nodobuscado))
		{
			return 0;
		}
		else
		{
			if(tieneHijosIzq(this))
			{
				int n = this.izq.nivel(nodobuscado);
				if(n != -1)
				{
					return n+1;
				}
			}
			if(tieneHijosDcha(this))
			{
				int n = this.dcha.nivel(nodobuscado);
				if(n != -1)
				{
					return n+1;
				}
			}
			return (-1);
		}
	} 
	*/
	
	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}	
	
}
