package datos;

import java.util.List;

import entidad.Rol;

public interface IRolDao {
	public List<Rol> obtenerTodos();
	public Rol obtenerUno(int id);
	public boolean insertar(Rol rol);
	public boolean editar(Rol rol);
	public boolean borrar(int id);
}
