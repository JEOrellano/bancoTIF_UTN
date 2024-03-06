package datosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.IPrestamoDao;
import entidad.Prestamo;
import negocioImpl.EstadoPrestamoNegImpl;
import negocioImpl.UsuarioNegImpl;

public class PrestamoDaoImpl implements IPrestamoDao{
	private ConexionDaoImpl cn;
	private EstadoPrestamoNegImpl estadoPrestamoNegImpl;
	private UsuarioNegImpl usuarioNegImpl;
	
	public PrestamoDaoImpl() {
		
	}

	@Override
	public List<Prestamo> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Prestamo> lista = new ArrayList<Prestamo>();
		estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodPrestamo_Pre, Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre FROM Prestamo;");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setCodigoPrestamo(rs.getInt("CodPrestamo_Pre"));
				prestamo.setFecha(LocalDate.parse(rs.getString("Fecha_Pre")));
				prestamo.setImportePagar(rs.getDouble("ImportePagar_Pre"));
				prestamo.setImportePedido(rs.getDouble("ImportePedido_Pre"));
				prestamo.setPlazoPago(rs.getInt("PlazoPago_Pre"));
				prestamo.setMontoCuota(rs.getDouble("MontoCuota_Pre"));
				prestamo.setCuotas(rs.getInt("Cuotas_Pre"));
				prestamo.setEstado(rs.getInt("Estado"));
				prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(rs.getInt("CodEstadoPrestamo_Pre")));
				prestamo.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Pre")));
				lista.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Prestamo obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Prestamo prestamo = new Prestamo();
		estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodPrestamo_Pre, Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre FROM Prestamo WHERE CodPrestamo_Pre = " + id + ";");
			rs.next();
			prestamo.setCodigoPrestamo(rs.getInt("CodPrestamo_Pre"));
			prestamo.setFecha(LocalDate.parse(rs.getString("Fecha_Pre")));
			prestamo.setImportePagar(rs.getDouble("ImportePagar_Pre"));
			prestamo.setImportePedido(rs.getDouble("ImportePedido_Pre"));
			prestamo.setPlazoPago(rs.getInt("PlazoPago_Pre"));
			prestamo.setMontoCuota(rs.getDouble("MontoCuota_Pre"));
			prestamo.setCuotas(rs.getInt("Cuotas_Pre"));
			prestamo.setEstado(rs.getInt("Estado"));
			prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(rs.getInt("CodEstadoPrestamo_Pre")));
			prestamo.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Pre")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return prestamo;
	}

	@Override
	public boolean insertar(Prestamo prestamo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO Prestamo (Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre) VALUES ('"+
			prestamo.getFecha() + "', " +
			prestamo.getImportePagar() + ", " +
			prestamo.getImportePedido() + ", " +
			prestamo.getPlazoPago() + ", " +
			prestamo.getMontoCuota() + ", " +
			prestamo.getCuotas() + ", " +
			prestamo.getEstado() + ", " +
			prestamo.getEstadoPrestamo().getCodigoEstadoPrestamo() + ", '" +
			prestamo.getCliente().getDni() + "');";
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
	public boolean editar(Prestamo prestamo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Prestamo SET Fecha_Pre = '" + prestamo.getFecha() +
				"', ImportePagar_Pre = " + prestamo.getImportePagar() +
				", ImportePedido_Pre = " + prestamo.getImportePedido() +
				", PlazoPago_Pre = " + prestamo.getPlazoPago() +
				", MontoCuota_Pre = " + prestamo.getMontoCuota() +
				", Cuotas_Pre = " + prestamo.getCuotas() +
				", Estado = " + prestamo.getEstado() +
				", CodEstadoPrestamo_Pre = " + prestamo.getEstadoPrestamo().getCodigoEstadoPrestamo() +
				", DniCliente_Pre = '" + prestamo.getCliente().getDni() +
				"' WHERE CodPrestamo_Pre = " + prestamo.getCodigoPrestamo() + ";";
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
		String query = "UPDATE Prestamo SET Estado = 0 WHERE CodPrestamo_Pre = " + id + ";";
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
	public List<Prestamo> obtenerFiltradosCliente(String id) {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Prestamo> lista = new ArrayList<Prestamo>();
		estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodPrestamo_Pre, Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre FROM Prestamo WHERE DniCliente_Pre = '" + id + "';");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setCodigoPrestamo(rs.getInt("CodPrestamo_Pre"));
				prestamo.setFecha(LocalDate.parse(rs.getString("Fecha_Pre")));
				prestamo.setImportePagar(rs.getDouble("ImportePagar_Pre"));
				prestamo.setImportePedido(rs.getDouble("ImportePedido_Pre"));
				prestamo.setPlazoPago(rs.getInt("PlazoPago_Pre"));
				prestamo.setMontoCuota(rs.getDouble("MontoCuota_Pre"));
				prestamo.setCuotas(rs.getInt("Cuotas_Pre"));
				prestamo.setEstado(rs.getInt("Estado"));
				prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(rs.getInt("CodEstadoPrestamo_Pre")));
				prestamo.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Pre")));
				lista.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public List<Prestamo> filtroEstadisticas(Double montoMin, Double montoMax, LocalDate fechaMin, LocalDate fechaMax,
			int cuotaMin, int cuotaMax) {
		System.out.println("ENTRO DAO PASANDO POR NEGOCIO:");
		System.out.println(montoMin);
		System.out.println(montoMax);
		System.out.println(fechaMin);
		System.out.println(fechaMax);
		System.out.println(cuotaMin);
		System.out.println(cuotaMax);
		cn = new ConexionDaoImpl();
		cn.open();
		List<Prestamo> lista = new ArrayList<Prestamo>();
		estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT CodPrestamo_Pre, Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre FROM Prestamo "+
				" WHERE ImportePedido_Pre >= " + montoMin +
				" AND ImportePedido_Pre <= " + montoMax +
				" AND Cuotas_Pre >= " + cuotaMin +
				" AND Cuotas_Pre <= " + cuotaMax +
				" AND Fecha_Pre >= '" + fechaMin +
				"' AND Fecha_Pre <= '" + fechaMax +
			"';");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setCodigoPrestamo(rs.getInt("CodPrestamo_Pre"));
				prestamo.setFecha(LocalDate.parse(rs.getString("Fecha_Pre")));
				prestamo.setImportePagar(rs.getDouble("ImportePagar_Pre"));
				prestamo.setImportePedido(rs.getDouble("ImportePedido_Pre"));
				prestamo.setPlazoPago(rs.getInt("PlazoPago_Pre"));
				prestamo.setMontoCuota(rs.getDouble("MontoCuota_Pre"));
				prestamo.setCuotas(rs.getInt("Cuotas_Pre"));
				prestamo.setEstado(rs.getInt("Estado"));
				prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(rs.getInt("CodEstadoPrestamo_Pre")));
				prestamo.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Pre")));
				lista.add(prestamo);
			}
			System.out.println("SELECT CodPrestamo_Pre, Fecha_Pre, ImportePagar_Pre, ImportePedido_Pre, PlazoPago_Pre, MontoCuota_Pre, Cuotas_Pre, Estado, CodEstadoPrestamo_Pre, DniCliente_Pre FROM Prestamo "+
				" WHERE ImportePedido_Pre >= " + montoMin +
				" AND ImportePedido_Pre <= " + montoMax +
				" AND Cuotas_Pre >= " + cuotaMin +
				" AND Cuotas_Pre <= " + cuotaMax +
				" AND Fecha_Pre >= '" + fechaMin +
				"' AND Fecha_Pre <= '" + fechaMax +
			"';");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return lista;
	}

}
