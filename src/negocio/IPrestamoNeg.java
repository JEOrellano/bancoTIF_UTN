package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidad.Prestamo;

public interface IPrestamoNeg {
	public ArrayList<Prestamo> listarTodos();
	public Prestamo obtenerUno(int id);
	public boolean insertar(Prestamo prestamo);
	public boolean editar(Prestamo prestamo);
	public boolean borrar(int id);
	public ArrayList<Prestamo> listarFiltradosCliente(String id);
	public List<Prestamo> listarFiltroEstadisticas (Double montoMin, Double montoMax, LocalDate fechaMin, LocalDate fechaMax, int cuotaMin, int cuotaMax);
}
