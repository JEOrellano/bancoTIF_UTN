package negocioImpl;

import java.util.ArrayList;

import datosImpl.TipoCuentaDaoImpl;
import entidad.TipoCuenta;
import negocio.ITipoCuentaNeg;

public class TipoCuentaNegImpl implements ITipoCuentaNeg {
	private TipoCuentaDaoImpl tipoCuentaDaoImpl = new TipoCuentaDaoImpl();

	@Override
	public ArrayList<TipoCuenta> listarTodos() {
		return (ArrayList<TipoCuenta>) tipoCuentaDaoImpl.obtenerTodos();
	}

	@Override
	public TipoCuenta obtenerUno(int id) {
		return tipoCuentaDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(TipoCuenta tipoCuenta) {
		return tipoCuentaDaoImpl.insertar(tipoCuenta);
	}

	@Override
	public boolean editar(TipoCuenta tipoCuenta) {
		return tipoCuentaDaoImpl.editar(tipoCuenta);
	}

	@Override
	public boolean borrar(int id) {
		return tipoCuentaDaoImpl.borrar(id);
	}

}
