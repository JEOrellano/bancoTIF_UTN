package datos;

import java.util.List;

import entidad.TipoCuenta;

public interface ITipoCuentaDao {
	public List<TipoCuenta> obtenerTodos();
	public TipoCuenta obtenerUno(int id);
	public boolean insertar(TipoCuenta tipoCuenta);
	public boolean editar(TipoCuenta tipoCuenta);
	public boolean borrar(int id);
}
