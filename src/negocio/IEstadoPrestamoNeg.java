package negocio;

import java.util.ArrayList;

import entidad.EstadoPrestamo;

public interface IEstadoPrestamoNeg {
	public ArrayList<EstadoPrestamo> listarTodos();
	public EstadoPrestamo obtenerUno(int id);
	public boolean insertar(EstadoPrestamo estadoPrestamo);
	public boolean editar(EstadoPrestamo estadoPrestamo);
	public boolean borrar(int id);
}
