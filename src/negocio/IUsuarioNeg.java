package negocio;

import java.util.ArrayList;

import entidad.Usuario;
import excepciones.DuplicadaPKException;
import excepciones.DuplicadaUKException;

public interface IUsuarioNeg {
	public ArrayList<Usuario> listarTodos();
	public Usuario obtenerUno(String id);
	public boolean insertar(Usuario usuario) throws DuplicadaPKException, DuplicadaUKException;
	public boolean editar(Usuario usuario);
	public boolean borrar(String id);
	public Usuario login(String user, String clave);
	public boolean existeUser(String user);
	public boolean existeDni(String dni);
}
