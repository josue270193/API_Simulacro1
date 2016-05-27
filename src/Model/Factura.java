package Model;

import java.util.Vector;

public class Factura 
{
	private int mes;
	private int año;
	private int numero;
	private Vector<ItemVenta>items;
	
	public Factura(int mes, int año, int nro) 
	{
		super();
		this.mes = mes;
		this.año = año;
		this.numero = nro;
		items = new Vector<ItemVenta>();
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
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
