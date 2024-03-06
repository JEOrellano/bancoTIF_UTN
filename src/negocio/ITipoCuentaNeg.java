package negocio;

import java.util.ArrayList;

import entidad.TipoCuenta;

public interface ITipoCuentaNeg {
	public ArrayList<TipoCuenta> listarTodos();
	public TipoCuenta obtenerUno(int id);
	public boolean insertar(TipoCuenta tipoCuenta);
	public boolean editar(TipoCuenta tipoCuenta);
	public boolean borrar(int id);
}
