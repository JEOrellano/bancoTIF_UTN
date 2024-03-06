package negocioImpl;

import java.util.ArrayList;

import datosImpl.RolDaoImpl;
import entidad.Rol;
import negocio.IRolNeg;

public class RolNegImpl implements IRolNeg{
	private RolDaoImpl rolDaoImpl = new RolDaoImpl();
	
	public RolNegImpl(){
		
	}

	public RolNegImpl(RolDaoImpl rolDaoImpl) {
		this.rolDaoImpl = rolDaoImpl;
	}

	@Override
	public ArrayList<Rol> listarTodos() {
		return (ArrayList<Rol>) rolDaoImpl.obtenerTodos();
	}

	@Override
	public Rol obtenerUno(int id) {
		return rolDaoImpl.obtenerUno(id);
	}

	@Override
	public boolean insertar(Rol rol) {
		return rolDaoImpl.insertar(rol);
	}

	@Override
	public boolean editar(Rol rol) {
		return rolDaoImpl.editar(rol);
	}

	@Override
	public boolean borrar(int id) {
		return rolDaoImpl.borrar(id);
	}

}
