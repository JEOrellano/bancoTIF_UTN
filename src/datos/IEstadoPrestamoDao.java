package datos;

import java.util.List;

import entidad.EstadoPrestamo;

public interface IEstadoPrestamoDao {
	public List<EstadoPrestamo> obtenerTodos();
	public EstadoPrestamo obtenerUno(int id);
	public boolean insertar(EstadoPrestamo estadoPrestamo);
	public boolean editar(EstadoPrestamo estadoPrestamo);
	public boolean borrar(int id);
}
