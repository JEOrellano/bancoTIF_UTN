package negocioImpl;

import java.util.ArrayList;

import datosImpl.TipoMovimientoDaoImpl;
import entidad.TipoMovimiento;
import negocio.ITipoMovimientoNeg;

public class TipoMovimientoNegImpl implements ITipoMovimientoNeg {
	private TipoMovimientoDaoImpl tipoMovimientoDaoImpl = new TipoMovimientoDaoImpl();
	
	public TipoMovimientoNegImpl() {
		
	}
	
	public TipoMovimientoNegImpl(TipoMovimientoDaoImpl tipoMovimientoDaoImpl) {
		this.tipoMovimientoDaoImpl = tipoMovimientoDaoImpl;
	}

	@Override
	public ArrayList<TipoMovimiento> listarTodos() {
		return (ArrayList<TipoMovimiento>) tipoMovimientoDaoImpl.obtenerTodos();
	}

	@Override
	public TipoMovimiento obtenerUno(int id) {
		return tipoMovimientoDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(TipoMovimiento tipoMovimiento) {
		return tipoMovimientoDaoImpl.insertar(tipoMovimiento);
	}

	@Override
	public boolean editar(TipoMovimiento tipoMovimiento) {
		return tipoMovimientoDaoImpl.editar(tipoMovimiento);
	}

	@Override
	public boolean borrar(int id) {
		return tipoMovimientoDaoImpl.borrar(id);
	}

}
