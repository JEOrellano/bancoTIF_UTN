package negocioImpl;

import java.util.ArrayList;

import datosImpl.CuentaDaoImpl;
import entidad.Cuenta;
import negocio.ICuentaNeg;

public class CuentaNegImpl implements ICuentaNeg {
	private CuentaDaoImpl cuentaDaoImpl = new CuentaDaoImpl();

	public CuentaNegImpl() {
		
	}
	
	public CuentaNegImpl(CuentaDaoImpl cuentaDaoImpl) {
		this.cuentaDaoImpl = cuentaDaoImpl;
	}
	
	@Override
	public ArrayList<Cuenta> listarTodos() {
		return (ArrayList<Cuenta>) cuentaDaoImpl.obtenerTodos();
	}

	@Override
	public Cuenta obtenerUno(int id) {
		return cuentaDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Cuenta cuenta) {
		return cuentaDaoImpl.insertar(cuenta);
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		return cuentaDaoImpl.editar(cuenta);
	}

	@Override
	public boolean borrar(int id) {
		return cuentaDaoImpl.borrar(id);
	}

	@Override
	public ArrayList<Cuenta> listarFiltradosCliente(String id) {
		return (ArrayList<Cuenta>) cuentaDaoImpl.obtenerFiltradosCliente(id);
	}

	@Override
	public Cuenta listarFiltradoCBU(String id) {
		return cuentaDaoImpl.obtenerFiltradoCBU(id);
	}

	@Override
	public boolean existeCBU(String cbu) {
		return cuentaDaoImpl.existeCBU(cbu);
	}

	@Override
	public int listarSiguienteId() {
		return cuentaDaoImpl.obtenerSiguienteId();
	}

}
