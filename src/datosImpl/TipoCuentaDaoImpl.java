package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.ITipoCuentaDao;
import entidad.TipoCuenta;

public class TipoCuentaDaoImpl implements ITipoCuentaDao {
	private ConexionDaoImpl cn;
	
	public TipoCuentaDaoImpl() {
		
	}
	
	@Override
	public List<TipoCuenta> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<TipoCuenta> lista = new ArrayList<TipoCuenta>();
		try {
			ResultSet rs = cn.query("SELECT CodTipoCuenta_TipCue, Descripcion_TipCue, Estado FROM TipoCuenta;");
			while (rs.next()) {
				TipoCuenta tipoCuenta = new TipoCuenta();
				tipoCuenta.setCodigoTipoCuenta(rs.getInt("CodTipoCuenta_TipCue"));
				tipoCuenta.setDescripcion(rs.getString("Descripcion_TipCue"));
				tipoCuenta.setEstado(rs.getInt("Estado"));
				lista.add(tipoCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public TipoCuenta obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		TipoCuenta tipoCuenta = new TipoCuenta();
		try {
			ResultSet rs = cn.query("SELECT CodTipoCuenta_TipCue, Descripcion_TipCue, Estado FROM TipoCuenta WHERE CodTipoCuenta_TipCue = " + id + ";");
			rs.next();
			tipoCuenta.setCodigoTipoCuenta(rs.getInt("CodTipoCuenta_TipCue"));
			tipoCuenta.setDescripcion(rs.getString("Descripcion_TipCue"));
			tipoCuenta.setEstado(rs.getInt("Estado"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return tipoCuenta;
	}

	@Override
	public boolean insertar(TipoCuenta tipoCuenta) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO TipoCuenta (Descripcion_TipCue, Estado) VALUES ('" +
				tipoCuenta.getDescripcion() + "', " +
				tipoCuenta.getEstado() +
				") WHERE CodTipoCuenta_TipCue = " + tipoCuenta.getCodigoTipoCuenta() + ";";
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
	public boolean editar(TipoCuenta tipoCuenta) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE TipoCuenta SET Descripcion_TipCue = '" + tipoCuenta.getDescripcion() +
				"', Estado = " + tipoCuenta.getEstado() +
				" WHERE CodTipoCuenta_TipCue = " + tipoCuenta.getCodigoTipoCuenta() + ";";
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
		String query = "UPDATE TipoCuenta SET Estado = 0 WHERE CodTipoCuenta_TipCue = " + id + ";";
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
