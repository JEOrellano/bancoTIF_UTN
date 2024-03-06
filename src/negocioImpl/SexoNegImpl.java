package negocioImpl;

import java.util.ArrayList;

import datosImpl.SexoDaoImpl;
import entidad.Sexo;
import negocio.ISexoNeg;

public class SexoNegImpl implements ISexoNeg {
	private SexoDaoImpl sexoDaoImpl = new SexoDaoImpl();
	
	public SexoNegImpl() {
		
	}

	public SexoNegImpl(SexoDaoImpl sexoDaoImpl) {
		this.sexoDaoImpl = sexoDaoImpl;
	}

	@Override
	public ArrayList<Sexo> listarTodos() {
		return (ArrayList<Sexo>) sexoDaoImpl.obtenerTodos();
	}

	@Override
	public Sexo obtenerUno(String id) {
		return sexoDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Sexo sexo) {
		return sexoDaoImpl.insertar(sexo);
	}

	@Override
	public boolean editar(Sexo sexo) {
		return sexoDaoImpl.editar(sexo);
	}

	@Override
	public boolean borrar(String id) {
		return sexoDaoImpl.borrar(id);
	}

}
