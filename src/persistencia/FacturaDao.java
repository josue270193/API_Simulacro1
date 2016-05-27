package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Factura;

public class FacturaDao {

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
	
	public List<Factura> obtenerTodos() {
		List<Factura> resultado = new ArrayList<Factura>();
		ItemVentaDao itemDao = new ItemVentaDao();
		itemDao.conectar();
		
		try {
			if (con == null || con.isClosed()){
				conectar();
			}
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from factura");
			
			while (rs.next()) {			
				Factura f = new Factura(
					rs.getInt("mes")	, 
					rs.getInt("año")	,
					rs.getInt("numero")	
					);
				
				itemDao.obtenerTodosPorFactura(f);				
				resultado.add(f);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
		
		return resultado;
	}
}
