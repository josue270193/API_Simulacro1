package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Factura;
import Model.Producto;

public class ItemVentaDao {

	private Connection con;
	
	public void conectar(){
		try{
            String userName = "sa";
            String password = "23503360";
            String url = "jdbc:sqlserver://DESKTOP-BSQG0TA\\SQLEXPRESS;databaseName=bd_api";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            con = DriverManager.getConnection (url, userName, password);
           
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}		
	
	public void desconectar(){		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void obtenerTodosPorFactura(Factura factura){				
		ProductoDao productoDao = new ProductoDao();
		productoDao.conectar();
		
		try{
			if (con == null || con.isClosed()){
				conectar();
			}
			
			PreparedStatement ps = con.prepareStatement("select * from itemventa where numero = ? ");
			ps.setInt(1, factura.getNumero());
			ResultSet r = ps.executeQuery();
			
			while (r.next()){
				Producto producto = productoDao.obtenerPorCodigo(r.getInt("codigo"));				
				factura.agregarItem(producto, r.getInt("cantidad"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {			
			desconectar();
		}		
	}
}
