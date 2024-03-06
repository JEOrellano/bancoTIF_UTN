package datosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.IMovimientoDao;
import entidad.Movimiento;
import negocioImpl.CuentaNegImpl;
import negocioImpl.TipoMovimientoNegImpl;

public class MovimientoDaoImpl implements IMovimientoDao {
	private ConexionDaoImpl cn;
	private CuentaNegImpl cuentaNegImpl;
	private TipoMovimientoNegImpl tipoMovimientoNegImpl;
	
	public MovimientoDaoImpl() {
		
	}

	@Override
	public List<Movimiento> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Movimiento> lista = new ArrayList<Movimiento>();
		cuentaNegImpl = new CuentaNegImpl();
		tipoMovimientoNegImpl = new TipoMovimientoNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodMovimiento_Mov, Fecha_Mov, Detalle_Mov, Importe_Mov, Estado, NumCuenta_Mov, CodTipoMovimiento_Mov FROM Movimiento;");
			while (rs.next()) {
				Movimiento movimiento = new Movimiento();
				movimiento.setCodigoMovimiento(rs.getInt("CodMovimiento_Mov"));
				movimiento.setFecha(LocalDate.parse(rs.getString("Fecha_Mov")));
				movimiento.setDetalle(rs.getString("Detalle_Mov"));
				movimiento.setImporte(rs.getDouble("Importe_Mov"));
				movimiento.setEstado(rs.getInt("Estado"));
				movimiento.setCuenta(cuentaNegImpl.obtenerUno(rs.getInt("NumCuenta_Mov")));
				movimiento.setTipoMovimiento(tipoMovimientoNegImpl.obtenerUno(rs.getInt("CodTipoMovimiento_Mov")));
				lista.add(movimiento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Movimiento obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Movimiento movimiento = new Movimiento();
		cuentaNegImpl = new CuentaNegImpl();
		tipoMovimientoNegImpl = new TipoMovimientoNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodMovimiento_Mov, Fecha_Mov, Detalle_Mov, Importe_Mov, Estado, NumCuenta_Mov, CodTipoMovimiento_Mov FROM Movimiento WHERE CodMovimiento_Mov = " + id + ";");
			rs.next();
			movimiento.setCodigoMovimiento(rs.getInt("CodMovimiento_Mov"));
			movimiento.setFecha(LocalDate.parse(rs.getString("Fecha_Mov")));
			movimiento.setDetalle(rs.getString("Detalle_Mov"));
			movimiento.setImporte(rs.getDouble("Importe_Mov"));
			movimiento.setEstado(rs.getInt("Estado"));
			movimiento.setCuenta(cuentaNegImpl.obtenerUno(rs.getInt("NumCuenta_Mov")));
			movimiento.setTipoMovimiento(tipoMovimientoNegImpl.obtenerUno(rs.getInt("CodTipoMovimiento_Mov")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return movimiento;
	}

	@Override
	public boolean insertar(Movimiento movimiento) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO Movimiento (Fecha_Mov, Detalle_Mov, Importe_Mov, Estado, NumCuenta_Mov, CodTipoMovimiento_Mov) VALUES ('" + movimiento.getFecha() +	"', '" +
				movimiento.getDetalle() + "', " +
				movimiento.getImporte() + ", " +
				movimiento.getEstado() + ", " +
				movimiento.getCuenta().getNumeroCuenta() + ", " +
				movimiento.getTipoMovimiento().getCodigoTipoMovimiento() + ");";
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
	public boolean editar(Movimiento movimiento) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Movimiento SET Fecha_Mov = '" + movimiento.getFecha() +
				"', Detalle_Mov = '" + movimiento.getDetalle() +
				"', Importe_Mov = " + movimiento.getImporte() +
				", Estado = " + movimiento.getEstado() +
				", NumCuenta_Mov = " + movimiento.getCuenta().getNumeroCuenta() +
				", CodTipoMovimiento_Mov = " + movimiento.getTipoMovimiento().getCodigoTipoMovimiento() +
				" WHERE CodMovimiento_Mov = " + movimiento.getCodigoMovimiento() + ";";
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
		String query = "UPDATE Movimiento SET Estado = 0 WHERE CodMovimiento_Mov = " + id + ";";
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
	public List<Movimiento> obtenerFiltradosCuenta(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Movimiento> lista = new ArrayList<Movimiento>();
		cuentaNegImpl = new CuentaNegImpl();
		tipoMovimientoNegImpl = new TipoMovimientoNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodMovimiento_Mov, Fecha_Mov, Detalle_Mov, Importe_Mov, Estado, NumCuenta_Mov, CodTipoMovimiento_Mov FROM Movimiento WHERE NumCuenta_Mov = " + id + ";");
			while (rs.next()) {
				Movimiento movimiento = new Movimiento();
				movimiento.setCodigoMovimiento(rs.getInt("CodMovimiento_Mov"));
				movimiento.setFecha(LocalDate.parse(rs.getString("Fecha_Mov")));
				movimiento.setDetalle(rs.getString("Detalle_Mov"));
				movimiento.setImporte(rs.getDouble("Importe_Mov"));
				movimiento.setEstado(rs.getInt("Estado"));
				movimiento.setCuenta(cuentaNegImpl.obtenerUno(rs.getInt("NumCuenta_Mov")));
				movimiento.setTipoMovimiento(tipoMovimientoNegImpl.obtenerUno(rs.getInt("CodTipoMovimiento_Mov")));
				lista.add(movimiento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

}
