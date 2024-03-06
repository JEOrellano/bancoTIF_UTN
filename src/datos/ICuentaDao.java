package datos;

import java.util.List;

import entidad.Cuenta;

public interface ICuentaDao {
	public List<Cuenta> obtenerTodos();
	public Cuenta obtenerUno(int id);
	public boolean insertar(Cuenta cuenta);
	public boolean editar(Cuenta cuenta);
	public boolean borrar(int id);
	public List<Cuenta> obtenerFiltradosCliente(String id);
	public Cuenta obtenerFiltradoCBU(String id);
	public boolean existeCBU(String cbu);
	public int obtenerSiguienteId();
}
