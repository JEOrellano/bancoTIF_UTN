package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datos.IConexionDao;

public class ConexionDaoImpl implements IConexionDao{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdBanco?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
	protected Connection connection;
	
	@Override
	public Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.connection;
	}

	@Override
	public ResultSet query(String query) {
		Statement st;
		ResultSet rs=null;
		try {
			st= connection.createStatement();
			rs= st.executeQuery(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean execute(String query) {
		Statement st;
		boolean save = true;
		try {
			st = connection.createStatement();
		    st.executeUpdate(query);
		}
		catch(SQLException e) {
			save = false;
			e.printStackTrace();
		}
		return save;
	}

	@Override
	public boolean close() {
		boolean ok=true;
		try {
			connection.close();
		}
		catch(Exception e) {
			ok= false;
			e.printStackTrace();
		}
		return ok;
	}

}
