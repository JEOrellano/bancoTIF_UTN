package negocio;

import java.util.ArrayList;

import entidad.Cuenta;

public interface ICuentaNeg {
	public ArrayList<Cuenta> listarTodos();
	public Cuenta obtenerUno(int id);
	public boolean insertar(Cuenta cuenta);
	public boolean editar(Cuenta cuenta);
	public boolean borrar(int id);
	public ArrayList<Cuenta> listarFiltradosCliente(String id);
	public Cuenta listarFiltradoCBU(String id);
	public boolean existeCBU(String cbu);
	public int listarSiguienteId();
}
