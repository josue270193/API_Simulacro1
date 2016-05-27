package Model;

public class ItemVenta 
{
	private Producto producto;
	private float cantidad;

	public ItemVenta(Producto p, float cant) 
	{
		producto = p;
		cantidad = cant;
	}
	

	public float getSubTotal()
	{
		return producto.getPrecio()* cantidad;
	}

}
