package datos;

import java.time.LocalDate;
import java.util.List;

import entidad.Prestamo;

public interface IPrestamoDao {
	public List<Prestamo> obtenerTodos();
	public Prestamo obtenerUno(int id);
	public boolean insertar(Prestamo prestamo);
	public boolean editar(Prestamo prestamo);
	public boolean borrar(int id);
	public List<Prestamo> obtenerFiltradosCliente(String id);
	public List<Prestamo> filtroEstadisticas (Double montoMin, Double montoMax, LocalDate fechaMin, LocalDate fechaMax, int cuotaMin, int cuotaMax);
}
