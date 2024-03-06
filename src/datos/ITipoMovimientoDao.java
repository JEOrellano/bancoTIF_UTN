package datos;

import java.util.List;

import entidad.TipoMovimiento;

public interface ITipoMovimientoDao {
	public List<TipoMovimiento> obtenerTodos();
	public TipoMovimiento obtenerUno(int id);
	public boolean insertar(TipoMovimiento tipoMovimiento);
	public boolean editar(TipoMovimiento tipoMovimiento);
	public boolean borrar(int id);
}
