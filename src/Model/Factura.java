package Model;

import java.util.Vector;

public class Factura 
{
	private int mes;
	private int a�o;
	private int numero;
	private Vector<ItemVenta>items;
	
	public Factura(int mes, int a�o, int nro) 
	{
		super();
		this.mes = mes;
		this.a�o = a�o;
		this.numero = nro;
		items = new Vector<ItemVenta>();
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void agregarItem(Producto p, float cant)
	{
		items.addElement(new ItemVenta(p,cant));
	}
	
	public float getTotal()
	{
		float total = 0;
		for (int i=0; i< items.size();i++)
		{
			total = items.elementAt(i).getSubTotal();
		}
		return total;
	}
	
	
}
