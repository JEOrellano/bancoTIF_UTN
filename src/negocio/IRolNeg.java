package negocio;

import java.util.ArrayList;

import entidad.Rol;

public interface IRolNeg {
	public ArrayList<Rol> listarTodos();
	public Rol obtenerUno(int id);
	public boolean insertar(Rol rol);
	public boolean editar(Rol rol);
	public boolean borrar(int id);
}
