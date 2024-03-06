package datosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.ICuentaDao;
import entidad.Cuenta;
import negocioImpl.TipoCuentaNegImpl;
import negocioImpl.UsuarioNegImpl;

public class CuentaDaoImpl implements ICuentaDao {
	private ConexionDaoImpl cn;
	private TipoCuentaNegImpl tipoCuentaNegImpl;
	private UsuarioNegImpl usuarioNegImpl;
	
	public CuentaDaoImpl() {
		
	}

	@Override
	public List<Cuenta> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Cuenta> lista = new ArrayList<Cuenta>();
		tipoCuentaNegImpl = new TipoCuentaNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT NumCuenta_Cue, FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue FROM Cuenta;");
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(rs.getInt("NumCuenta_Cue"));
				cuenta.setFechaCreacion(LocalDate.parse(rs.getString("FechaCreacion_Cue")));
				cuenta.setCbu(rs.getString("CBU_Cue"));
				cuenta.setSaldo(rs.getDouble("Saldo_Cue"));
				cuenta.setEstado(rs.getInt("Estado"));
				cuenta.setTipoCuenta(tipoCuentaNegImpl.obtenerUno(rs.getInt("CodTipoCuenta_Cue")));
				cuenta.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Cue")));
				lista.add(cuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Cuenta obtenerUno(int id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Cuenta  cuenta = new Cuenta();
		tipoCuentaNegImpl = new TipoCuentaNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT NumCuenta_Cue, FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue FROM Cuenta WHERE NumCuenta_Cue = " + id + ";");
			rs.next();
			cuenta.setNumeroCuenta(rs.getInt("NumCuenta_Cue"));
			cuenta.setFechaCreacion(LocalDate.parse(rs.getString("FechaCreacion_Cue")));
			cuenta.setCbu(rs.getString("CBU_Cue"));
			cuenta.setSaldo(rs.getDouble("Saldo_Cue"));
			cuenta.setEstado(rs.getInt("Estado"));
			cuenta.setTipoCuenta(tipoCuentaNegImpl.obtenerUno(rs.getInt("CodTipoCuenta_Cue")));
			cuenta.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Cue")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return cuenta;
	}

	@Override
	public boolean insertar(Cuenta cuenta) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO Cuenta (FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue) VALUES ('" +
				cuenta.getFechaCreacion() + "', '" +
				cuenta.getCbu()+ "', "+
				cuenta.getSaldo() + ", "+
				cuenta.getEstado() +", "+
				cuenta.getTipoCuenta().getCodigoTipoCuenta()+", '"+
				cuenta.getCliente().getDni() + "');";
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
	public boolean editar(Cuenta cuenta) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Cuenta SET FechaCreacion_Cue = '" + cuenta.getFechaCreacion() +
				"', CBU_Cue = "+ cuenta.getCbu() +
				", Saldo_Cue = " + cuenta.getSaldo() +
				", Estado = " + cuenta.getEstado() +
				", CodTipoCuenta_Cue = " + cuenta.getTipoCuenta().getCodigoTipoCuenta() +
				", DniCliente_Cue = '" + cuenta.getCliente().getDni() +
				"' WHERE NumCuenta_Cue = " + cuenta.getNumeroCuenta() + ";";
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
		String query = "UPDATE Cuenta SET Estado = 0 WHERE NumCuenta_Cue = " + id + ";";
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
	public List<Cuenta> obtenerFiltradosCliente(String id) {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Cuenta> lista = new ArrayList<Cuenta>();
		tipoCuentaNegImpl = new TipoCuentaNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT NumCuenta_Cue, FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue FROM Cuenta WHERE DniCliente_Cue = '" + id + "';");
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(rs.getInt("NumCuenta_Cue"));
				cuenta.setFechaCreacion(LocalDate.parse(rs.getString("FechaCreacion_Cue")));
				cuenta.setCbu(rs.getString("CBU_Cue"));
				cuenta.setSaldo(rs.getDouble("Saldo_Cue"));
				cuenta.setEstado(rs.getInt("Estado"));
				cuenta.setTipoCuenta(tipoCuentaNegImpl.obtenerUno(rs.getInt("CodTipoCuenta_Cue")));
				cuenta.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Cue")));
				lista.add(cuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Cuenta obtenerFiltradoCBU(String id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Cuenta cuenta = new Cuenta();
		tipoCuentaNegImpl = new TipoCuentaNegImpl();
		usuarioNegImpl = new UsuarioNegImpl();
		try {
			ResultSet rs = cn.query("SELECT NumCuenta_Cue, FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue FROM Cuenta WHERE CBU_Cue = '" + id + "';");
			rs.next();
			cuenta.setNumeroCuenta(rs.getInt("NumCuenta_Cue"));
			cuenta.setFechaCreacion(LocalDate.parse(rs.getString("FechaCreacion_Cue")));
			cuenta.setCbu(rs.getString("CBU_Cue"));
			cuenta.setSaldo(rs.getDouble("Saldo_Cue"));
			cuenta.setEstado(rs.getInt("Estado"));
			cuenta.setTipoCuenta(tipoCuentaNegImpl.obtenerUno(rs.getInt("CodTipoCuenta_Cue")));
			cuenta.setCliente(usuarioNegImpl.obtenerUno(rs.getString("DniCliente_Cue")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return cuenta;
	}

	@Override
	public boolean existeCBU(String cbu) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		try {
			ResultSet rs = cn.query("SELECT NumCuenta_Cue, FechaCreacion_Cue, CBU_Cue, Saldo_Cue, Estado, CodTipoCuenta_Cue, DniCliente_Cue FROM Cuenta WHERE CBU_Cue = " + cbu + ";");
			estado = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public int obtenerSiguienteId() {
		cn = new ConexionDaoImpl();
		cn.open();
		int ultimoId = 0;
		int auxIdMax = 0;
		try {
			ResultSet rs = cn.query("SELECT MAX(NumCuenta_Cue) AS id FROM Cuenta;");
			rs.next();
			ultimoId = rs.getInt(1);
			
			rs = cn.query("SELECT LAST_INSERT_ID() FROM Cuenta;");
			rs.next();
			auxIdMax = rs.getInt(1);
			if(auxIdMax > ultimoId) {
				ultimoId = auxIdMax;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return ++ultimoId;
	}

}
