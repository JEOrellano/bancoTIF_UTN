package negocio;

import java.util.ArrayList;

import entidad.TipoMovimiento;

public interface ITipoMovimientoNeg {
	public ArrayList<TipoMovimiento> listarTodos();
	public TipoMovimiento obtenerUno(int id);
	public boolean insertar(TipoMovimiento tipoMovimiento);
	public boolean editar(TipoMovimiento tipoMovimiento);
	public boolean borrar(int id);
}
