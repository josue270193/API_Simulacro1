package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Producto;

public class ProductoDao {

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

	public Producto obtenerPorCodigo(Integer codigo){		
		Producto resultado = null;
		
		try{
			if (con == null || con.isClosed()){
				conectar();
			}
			
			PreparedStatement ps = con.prepareStatement("select * from producto where codigo = ? ");
			ps.setInt(1, codigo);
			ResultSet r = ps.executeQuery();
			
			if (r.next()){
				
				resultado = new Producto(
						codigo, 
						r.getFloat("precio"), 
						r.getString("descripcion"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			desconectar();
		}
		
		return resultado;
	}
}
