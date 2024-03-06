package negocioImpl;

import java.util.ArrayList;

import datosImpl.EstadoPrestamoDaoImpl;
import entidad.EstadoPrestamo;
import negocio.IEstadoPrestamoNeg;

public class EstadoPrestamoNegImpl implements IEstadoPrestamoNeg{
	private EstadoPrestamoDaoImpl estadoPrestamoDaoImpl = new EstadoPrestamoDaoImpl();
	
	public EstadoPrestamoNegImpl() {
		
	}
	
	public EstadoPrestamoNegImpl(datosImpl.EstadoPrestamoDaoImpl estadoPrestamoDaoImpl) {
		this.estadoPrestamoDaoImpl = estadoPrestamoDaoImpl;
	}

	@Override
	public ArrayList<EstadoPrestamo> listarTodos() {
		return (ArrayList<EstadoPrestamo>) estadoPrestamoDaoImpl.obtenerTodos();
	}

	@Override
	public EstadoPrestamo obtenerUno(int id) {
		return estadoPrestamoDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(EstadoPrestamo estadoPrestamo) {
		return estadoPrestamoDaoImpl.insertar(estadoPrestamo);
	}

	@Override
	public boolean editar(EstadoPrestamo estadoPrestamo) {
		return estadoPrestamoDaoImpl.editar(estadoPrestamo);
	}

	@Override
	public boolean borrar(int id) {
		return estadoPrestamoDaoImpl.borrar(id);
	}

}
