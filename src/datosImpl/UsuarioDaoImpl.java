package datosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.IUsuarioDao;
import entidad.Usuario;
import excepciones.DuplicadaPKException;
import excepciones.DuplicadaUKException;
import negocioImpl.RolNegImpl;
import negocioImpl.SexoNegImpl;

public class UsuarioDaoImpl implements IUsuarioDao {
	private ConexionDaoImpl cn;
	private SexoNegImpl sexoNegImpl;
	private RolNegImpl rolNegImpl;

	
	public UsuarioDaoImpl() {
		
	}

	@Override
	public List<Usuario> obtenerTodos() {
		cn = new ConexionDaoImpl();
		cn.open();
		List<Usuario> lista = new ArrayList<Usuario>();
		sexoNegImpl = new SexoNegImpl();
		rolNegImpl = new RolNegImpl();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario;");
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setDni(rs.getString("DNI_Usu"));
				usuario.setCuil(rs.getString("CUIL_Usu"));
				usuario.setNombre(rs.getString("Nombre_Usu"));
				usuario.setApellido(rs.getString("Apellido_Usu"));
				usuario.setNacionalidad(rs.getString("Nacionalidad_Usu"));
				usuario.setFechaNacimiento(LocalDate.parse(rs.getString("FechaNacimiento_Usu")));
				usuario.setDireccion(rs.getString("Direccion_Usu"));
				usuario.setLocalidad(rs.getString("Localidad_Usu"));
				usuario.setProvincia(rs.getString("Provincia_Usu"));
				usuario.setCorreoElectronico(rs.getString("CorreoElectronico_Usu"));
				usuario.setTelefono(rs.getString("Telefono_Usu"));
				usuario.setUsuario(rs.getString("Usuario_Usu"));
				usuario.setContrasena(rs.getString("Contrasena_Usu"));
				usuario.setEstado(rs.getInt("Estado"));
				usuario.setSexo(sexoNegImpl.obtenerUno(rs.getString("CodSexo_Usu")));
				usuario.setRol(rolNegImpl.obtenerUno(rs.getInt("CodRol_Usu")));
				lista.add(usuario);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public Usuario obtenerUno(String id) {
		cn = new ConexionDaoImpl();
		cn.open();
		Usuario usuario = new Usuario();
		sexoNegImpl = new SexoNegImpl();
		rolNegImpl = new RolNegImpl();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE DNI_Usu = '" + id + "';");
			//System.out.println("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE DNI_Usu = '" + id + "';");
			rs.next();
			usuario.setDni(rs.getString("DNI_Usu"));
			usuario.setCuil(rs.getString("CUIL_Usu"));
			usuario.setNombre(rs.getString("Nombre_Usu"));
			usuario.setApellido(rs.getString("Apellido_Usu"));
			usuario.setNacionalidad(rs.getString("Nacionalidad_Usu"));
			usuario.setFechaNacimiento(LocalDate.parse(rs.getString("FechaNacimiento_Usu")));
			usuario.setDireccion(rs.getString("Direccion_Usu"));
			usuario.setLocalidad(rs.getString("Localidad_Usu"));
			usuario.setProvincia(rs.getString("Provincia_Usu"));
			usuario.setCorreoElectronico(rs.getString("CorreoElectronico_Usu"));
			usuario.setTelefono(rs.getString("Telefono_Usu"));
			usuario.setUsuario(rs.getString("Usuario_Usu"));
			usuario.setContrasena(rs.getString("Contrasena_Usu"));
			usuario.setEstado(rs.getInt("Estado"));
			usuario.setSexo(sexoNegImpl.obtenerUno(rs.getString("CodSexo_Usu")));
			usuario.setRol(rolNegImpl.obtenerUno(rs.getInt("CodRol_Usu")));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return usuario;
	}

	@Override
	public boolean insertar(Usuario usuario) throws DuplicadaPKException, DuplicadaUKException {
		boolean estado = true;
		String query = "INSERT INTO Usuario (DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu) VALUES ('" +
				usuario.getDni() + "', '" +
				usuario.getCuil() + "', '" +
				usuario.getNombre() + "', '" +
				usuario.getApellido() +	"', '" +
				usuario.getNacionalidad() +	"', '" +
				usuario.getFechaNacimiento() +	"', '" +
				usuario.getDireccion() + "', '" +
				usuario.getLocalidad() + "', '" +
				usuario.getProvincia() + "', '" +
				usuario.getCorreoElectronico() + "', '" +
				usuario.getTelefono() +	"', '" +
				usuario.getUsuario() + "', '" +
				usuario.getContrasena() + "', " +
				usuario.getEstado() + ", '" +
				usuario.getSexo().getCodigoSexo() + "', " +
				usuario.getRol().getCodigoRol() + ");";
		try {
			if (existeDni(usuario.getDni())) {
				throw new DuplicadaPKException();
			}
			if (existeCuil(usuario.getCuil())) {
				throw new DuplicadaUKException();
			}
			cn = new ConexionDaoImpl();
			cn.open();
			estado = cn.execute(query);
		} catch (DuplicadaPKException e) {
			e.printStackTrace();
			estado = false;
		} catch (DuplicadaUKException e) {
			e.printStackTrace();
			estado = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Usuario usuario) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Usuario SET CUIL_Usu = '" + usuario.getCuil() +
		"', Nombre_Usu = '" + usuario.getNombre() +
		"', Apellido_Usu = '" + usuario.getApellido() +
		"', Nacionalidad_Usu = '" + usuario.getNacionalidad() +
		"', FechaNacimiento_Usu = '" + usuario.getFechaNacimiento() +
		"', Direccion_Usu = '" + usuario.getDireccion() +
		"', Localidad_Usu = '" + usuario.getLocalidad() +
		"', Provincia_Usu = '" + usuario.getProvincia() +
		"', CorreoElectronico_Usu = '" + usuario.getCorreoElectronico() +
		"', Telefono_Usu = '" + usuario.getTelefono() +
		"', Usuario_Usu = '" + usuario.getUsuario() +
		"', Contrasena_Usu = '" + usuario.getContrasena() +
		"', Estado = " + usuario.getEstado() +
		", CodSexo_Usu = '" + usuario.getSexo().getCodigoSexo() +
		"', CodRol_Usu = " + usuario.getRol().getCodigoRol() +
		" WHERE DNI_Usu = '" + usuario.getDni() + "';";
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
	public boolean borrar(String id) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		String query = "UPDATE Usuario SET Estado = 0 WHERE DNI_Usu = '" + id + "';";
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public Usuario login(String user, String clave) {
		cn = new ConexionDaoImpl();
		cn.open();
		Usuario usuario = new Usuario();
		sexoNegImpl = new SexoNegImpl();
		rolNegImpl = new RolNegImpl();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE Usuario_Usu = '" + user + "' && Contrasena_Usu = '" + clave + "';");
			if(rs.next()){
				usuario.setDni(rs.getString("DNI_Usu"));
				usuario.setCuil(rs.getString("CUIL_Usu"));
				usuario.setNombre(rs.getString("Nombre_Usu"));
				usuario.setApellido(rs.getString("Apellido_Usu"));
				usuario.setNacionalidad(rs.getString("Nacionalidad_Usu"));
				usuario.setFechaNacimiento(LocalDate.parse(rs.getString("FechaNacimiento_Usu")));
				usuario.setDireccion(rs.getString("Direccion_Usu"));
				usuario.setLocalidad(rs.getString("Localidad_Usu"));
				usuario.setProvincia(rs.getString("Provincia_Usu"));
				usuario.setCorreoElectronico(rs.getString("CorreoElectronico_Usu"));
				usuario.setTelefono(rs.getString("Telefono_Usu"));
				usuario.setUsuario(rs.getString("Usuario_Usu"));
				usuario.setContrasena(rs.getString("Contrasena_Usu"));
				usuario.setEstado(rs.getInt("Estado"));
				usuario.setSexo(sexoNegImpl.obtenerUno(rs.getString("CodSexo_Usu")));
				usuario.setRol(rolNegImpl.obtenerUno(rs.getInt("CodRol_Usu")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return usuario;
	}

	@Override
	public boolean existeUser(String user) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE Usuario_Usu = '" + user + "';");
			estado = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean existeDni(String dni) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE DNI_Usu = '" + dni + "';");
			estado = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean existeCuil(String cuil) {
		boolean estado = true;
		cn = new ConexionDaoImpl();
		cn.open();
		try {
			ResultSet rs = cn.query("SELECT DNI_Usu, CUIL_Usu, Nombre_Usu, Apellido_Usu, Nacionalidad_Usu, FechaNacimiento_Usu, Direccion_Usu, Localidad_Usu, Provincia_Usu, CorreoElectronico_Usu, Telefono_Usu, Usuario_Usu, Contrasena_Usu, Estado, CodSexo_Usu, CodRol_Usu FROM Usuario WHERE CUIL_Usu = '" + cuil + "';");
			estado = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return estado;
	}

}
