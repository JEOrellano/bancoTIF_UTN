package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.IEstadoPrestamoDao;
import entidad.EstadoPrestamo;

public class EstadoPrestamoDaoImpl implements IEstadoPrestamoDao {
	private ConexionDaoImpl cn;
	
	public EstadoPrestamoDaoImpl() {
		
	}

	@Override
	public List<EstadoPrestamo> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<EstadoPrestamo> lista = new ArrayList<EstadoPrestamo>();
		try {
			ResultSet rs = cn.query("SELECT CodEstadoPrestamo_EstPre, Descripcion_EstPre, Estado FROM EstadoPrestamo;");
			while (rs.next()) {
				EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
				estadoPrestamo.setCodigoEstadoPrestamo(rs.getInt("CodEstadoPrestamo_EstPre"));
				estadoPrestamo.setDescripcion(rs.getString("Descripcion_EstPre"));
				estadoPrestamo.setEstado(rs.getInt("Estado"));
				lista.add(estadoPrestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public EstadoPrestamo obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
		try {
			ResultSet rs = cn.query("SELECT CodEstadoPrestamo_EstPre, Descripcion_EstPre, Estado FROM EstadoPrestamo WHERE CodEstadoPrestamo_EstPre = " + id + ";");
			rs.next();
			estadoPrestamo.setCodigoEstadoPrestamo(rs.getInt("CodEstadoPrestamo_EstPre"));
			estadoPrestamo.setDescripcion(rs.getString("Descripcion_EstPre"));
			estadoPrestamo.setEstado(rs.getInt("Estado"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estadoPrestamo;
	}

	@Override
	public boolean insertar(EstadoPrestamo estadoPrestamo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO EstadoPrestamo (Descripcion_EstPre, Estado) VALUES ('" + estadoPrestamo.getDescripcion() + "', " + estadoPrestamo.getEstado() + ");";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(EstadoPrestamo estadoPrestamo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE EstadoPrestamo SET Descripcion_EstPre = '" + estadoPrestamo.getDescripcion() + "', Estado = " + estadoPrestamo.getEstado() + " WHERE CodEstadoPrestamo_EstPre = '" + estadoPrestamo.getCodigoEstadoPrestamo() + "';";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean borrar(int id) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE EstadoPrestamo SET Estado = 0 WHERE CodEstadoPrestamo_EstPre = " + id + ";";
		try {
			estado = cn.execute(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

}
