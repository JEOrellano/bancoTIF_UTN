package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.IRolDao;
import entidad.Rol;

public class RolDaoImpl implements IRolDao {
	private ConexionDaoImpl cn;

	public RolDaoImpl() {
		
	}
	
	@Override
	public List<Rol> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Rol> lista = new ArrayList<Rol>();
		try {
			ResultSet rs = cn.query("SELECT CodRol_Rol, Descripcion_Rol, Estado FROM Rol;");
			while (rs.next()) {
				Rol rol = new Rol();
				rol.setCodigoRol(rs.getInt("CodRol_Rol"));
				rol.setDescripcion(rs.getString("Descripcion_Rol"));
				rol.setEstado(rs.getInt("Estado"));
				lista.add(rol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Rol obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Rol rol = new Rol();
		try {
			ResultSet rs = cn.query("SELECT CodRol_Rol, Descripcion_Rol, Estado FROM Rol WHERE CodRol_Rol = " + id + ";");
			rs.next();
			rol = new Rol();
			rol.setCodigoRol(rs.getInt("CodRol_Rol"));
			rol.setDescripcion(rs.getString("Descripcion_Rol"));
			rol.setEstado(rs.getInt("Estado"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return rol;
	}

	@Override
	public boolean insertar(Rol rol) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO Rol(Descripcion_Rol, Estado) VALUES ('"+ rol.getDescripcion() +"', " + rol.getEstado() + ");";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Rol rol) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Rol SET Descripcion_Rol = '" + rol.getDescripcion() + "', Estado = " + rol.getEstado() + " WHERE CodRol_Rol = " + rol.getCodigoRol() + ";";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean borrar(int id) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Rol SET Estado = 0 WHERE CodRol_Rol = " + id + ";";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}

}
