package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.ITipoMovimientoDao;
import entidad.TipoMovimiento;

public class TipoMovimientoDaoImpl implements ITipoMovimientoDao {
	private ConexionDaoImpl cn;

	public TipoMovimientoDaoImpl() {
		
	}
	
	@Override
	public List<TipoMovimiento> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<TipoMovimiento> lista = new ArrayList<TipoMovimiento>();
		try {
			ResultSet rs = cn.query("SELECT CodTipoMovimiento_TipMov, Descripcion_TipMov, Estado FROM TipoMovimiento;");
			while (rs.next()) {
				TipoMovimiento tipoMovimiento = new TipoMovimiento();
				tipoMovimiento.setCodigoTipoMovimiento(rs.getInt("CodTipoMovimiento_TipMov"));
				tipoMovimiento.setDescripcion(rs.getString("Descripcion_TipMov"));
				tipoMovimiento.setEstado(rs.getInt("Estado"));
				lista.add(tipoMovimiento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public TipoMovimiento obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		TipoMovimiento tipoMovimiento = new TipoMovimiento();
		try {
			ResultSet rs = cn.query("SELECT CodTipoMovimiento_TipMov, Descripcion_TipMov, Estado FROM TipoMovimiento WHERE CodTipoMovimiento_TipMov = " + id + ";");
			rs.next();
			tipoMovimiento.setCodigoTipoMovimiento(rs.getInt("CodTipoMovimiento_TipMov"));
			tipoMovimiento.setDescripcion(rs.getString("Descripcion_TipMov"));
			tipoMovimiento.setEstado(rs.getInt("Estado"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return tipoMovimiento;
	}

	@Override
	public boolean insertar(TipoMovimiento tipoMovimiento) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO TipoMovimiento (Descripcion_TipMov, Estado) VALUES ('" +
				tipoMovimiento.getDescripcion() + "', " +
				tipoMovimiento.getEstado()+ ");";
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
	public boolean editar(TipoMovimiento tipoMovimiento) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE TipoMovimiento SET Descripcion_TipMov = '" + tipoMovimiento.getDescripcion() +
				"', Estado = " + tipoMovimiento.getEstado() +
				" WHERE CodTipoMovimiento_TipMov = " + tipoMovimiento.getCodigoTipoMovimiento() + ";";
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
		String query = "UPDATE TipoMovimiento SET Estado = 0 WHERE CodTipoMovimiento_TipMov = " + id + ";";
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
