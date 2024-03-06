package datos;

import java.util.List;

import entidad.Movimiento;

public interface IMovimientoDao {
	public List<Movimiento> obtenerTodos();
	public Movimiento obtenerUno(int id);
	public boolean insertar(Movimiento movimiento);
	public boolean editar(Movimiento movimiento);
	public boolean borrar(int id);
	public List<Movimiento> obtenerFiltradosCuenta(int id);
}
