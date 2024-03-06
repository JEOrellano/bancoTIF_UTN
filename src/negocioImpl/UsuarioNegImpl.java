package negocioImpl;

import java.util.ArrayList;

import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;
import excepciones.DuplicadaPKException;
import excepciones.DuplicadaUKException;
import negocio.IUsuarioNeg;

public class UsuarioNegImpl implements IUsuarioNeg {
	private UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
	
	public UsuarioNegImpl() {
		
	}

	public UsuarioNegImpl(UsuarioDaoImpl usuarioDaoImpl) {
		this.usuarioDaoImpl = usuarioDaoImpl;
	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		return (ArrayList<Usuario>) usuarioDaoImpl.obtenerTodos();
	}

	@Override
	public Usuario obtenerUno(String id) {
		return usuarioDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Usuario usuario) throws DuplicadaPKException, DuplicadaUKException {
		return usuarioDaoImpl.insertar(usuario);
	}

	@Override
	public boolean editar(Usuario usuario) {
		return usuarioDaoImpl.editar(usuario);
	}

	@Override
	public boolean borrar(String id) {
		return usuarioDaoImpl.borrar(id);
	}

	@Override
	public Usuario login(String user, String clave) {
		return usuarioDaoImpl.login(user, clave);
	}

	@Override
	public boolean existeUser(String user) {
		return usuarioDaoImpl.existeUser(user);
	}

	@Override
	public boolean existeDni(String dni) {
		return usuarioDaoImpl.existeDni(dni);
	}

}
