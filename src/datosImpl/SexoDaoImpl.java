package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.ISexoDao;
import entidad.Sexo;

public class SexoDaoImpl implements ISexoDao{
	private ConexionDaoImpl cn;
	
	public SexoDaoImpl() {
		
	}

	@Override
	public List<Sexo> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Sexo> lista = new ArrayList<Sexo>();
		try {
			ResultSet rs = cn.query("SELECT CodSexo_Sex, Descripcion_Sex, Estado FROM Sexo;");
			while (rs.next()) {
				Sexo sexo = new Sexo();
				sexo.setCodigoSexo(rs.getString("CodSexo_Sex"));
				sexo.setDescripcion(rs.getString("Descripcion_Sex"));
				sexo.setEstado(rs.getInt("Estado"));
				lista.add(sexo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Sexo obtenerUno(String id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Sexo sexo = new Sexo();
		try {
			ResultSet rs = cn.query("SELECT CodSexo_Sex, Descripcion_Sex, Estado FROM Sexo where CodSexo_Sex = '" + id + "';");
			rs.next();
			sexo.setCodigoSexo(rs.getString("CodSexo_Sex"));
			sexo.setDescripcion(rs.getString("Descripcion_Sex"));
			sexo.setEstado(rs.getInt("Estado"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return sexo;
	}

	@Override
	public boolean insertar(Sexo sexo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "INSERT INTO Sexo (CodSexo_Sex, Descripcion_Sex, Estado) VALUES ('" + sexo.getCodigoSexo() + "', '" + sexo.getDescripcion() + "', " + sexo.getEstado() + ");";
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
	public boolean editar(Sexo sexo) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Sex SET Descripcion_Sex = '"+ sexo.getDescripcion() +"', Estado = " + sexo.getEstado() + " WHERE CodSexo_Sex = '" + sexo.getCodigoSexo() + "';";
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
	public boolean borrar(String id) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Sexo SET Estado = 0 WHERE CodSexo_Sex = '" + id + "';";
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
