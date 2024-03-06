package negocio;

import java.util.ArrayList;

import entidad.Movimiento;

public interface IMovimientoNeg {
	public ArrayList<Movimiento> listarTodos();
	public Movimiento obtenerUno(int id);
	public boolean insertar(Movimiento movimiento);
	public boolean editar(Movimiento movimiento);
	public boolean borrar(int id);
	public ArrayList<Movimiento> listarFiltradosCuenta(int id);
	
}
