package Controller;

import java.util.Vector;

import Model.Factura;
import persistencia.FacturaDao;

public class Supermercado
{
	private Vector<Factura>ventas;
	private static Supermercado instancia;
	
	public static Supermercado getInstancia()
	{
		if (instancia ==null)
			instancia = new Supermercado();
		return instancia;
	}
	
	private Supermercado(){
		ventas = new Vector<Factura>();
		cargarDatoFactura();
	}
	
	public float getTotal(int mes, int año){		
		float total=0;
				
		for (int i=0;i<ventas.size();i++){
			if (ventas.elementAt(i).getAño()== año && ventas.elementAt(i).getMes()== mes){
				total = ventas.elementAt(i).getTotal();
			}
		}
		return total;
	}
	
	private void cargarDatoFactura(){
		FacturaDao dao = new FacturaDao();		
		ventas.addAll(dao.obtenerTodos());
	}
	
}
