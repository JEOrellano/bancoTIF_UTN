package negocioImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datosImpl.PrestamoDaoImpl;
import entidad.Prestamo;
import negocio.IPrestamoNeg;

public class PrestamoNegImpl implements IPrestamoNeg {
	private PrestamoDaoImpl prestamoDaoImpl = new PrestamoDaoImpl();
	
	public PrestamoNegImpl() {
		
	}

	public PrestamoNegImpl(PrestamoDaoImpl prestamoDaoImpl) {
		this.prestamoDaoImpl = prestamoDaoImpl;
	}

	@Override
	public ArrayList<Prestamo> listarTodos() {
		return (ArrayList<Prestamo>) prestamoDaoImpl.obtenerTodos();
	}

	@Override
	public Prestamo obtenerUno(int id) {
		return prestamoDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Prestamo prestamo) {
		return prestamoDaoImpl.insertar(prestamo);
	}

	@Override
	public boolean editar(Prestamo prestamo) {
		return prestamoDaoImpl.editar(prestamo);
	}

	@Override
	public boolean borrar(int id) {
		return prestamoDaoImpl.borrar(id);
	}

	@Override
	public ArrayList<Prestamo> listarFiltradosCliente(String id) {
		return (ArrayList<Prestamo>)prestamoDaoImpl.obtenerFiltradosCliente(id);
	}

	@Override
	public List<Prestamo> listarFiltroEstadisticas(Double montoMin, Double montoMax, LocalDate fechaMin,
			LocalDate fechaMax, int cuotaMin, int cuotaMax) {
		return (ArrayList<Prestamo>)prestamoDaoImpl.filtroEstadisticas(montoMin, montoMax, fechaMin, fechaMax, cuotaMin, cuotaMax);
	}

}
