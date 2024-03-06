package datos;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IConexionDao {
	public Connection open();
	public ResultSet query(String query);
	public boolean execute(String query);
	public boolean close();
}
