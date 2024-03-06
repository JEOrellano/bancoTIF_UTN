package negocioImpl;

import java.util.ArrayList;

import datosImpl.MovimientoDaoImpl;
import entidad.Movimiento;
import negocio.IMovimientoNeg;

public class MovimientoNegImpl implements IMovimientoNeg {
	private MovimientoDaoImpl movimientoDaoImpl = new MovimientoDaoImpl();
	
	public MovimientoNegImpl() {
		
	}

	public MovimientoNegImpl(MovimientoDaoImpl movimientoDaoImpl) {
		this.movimientoDaoImpl = movimientoDaoImpl;
	}

	@Override
	public ArrayList<Movimiento> listarTodos() {
		return (ArrayList<Movimiento>) movimientoDaoImpl.obtenerTodos();
	}

	@Override
	public Movimiento obtenerUno(int id) {
		return movimientoDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Movimiento movimiento) {
		return movimientoDaoImpl.insertar(movimiento);
	}

	@Override
	public boolean editar(Movimiento movimiento) {
		return movimientoDaoImpl.editar(movimiento);
	}

	@Override
	public boolean borrar(int id) {
		return movimientoDaoImpl.borrar(id);
	}

	@Override
	public ArrayList<Movimiento> listarFiltradosCuenta(int id) {
		return (ArrayList<Movimiento>) movimientoDaoImpl.obtenerFiltradosCuenta(id);
	}

}
