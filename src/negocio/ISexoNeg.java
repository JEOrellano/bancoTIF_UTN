package negocio;

import java.util.ArrayList;

import entidad.Sexo;

public interface ISexoNeg {
	public ArrayList<Sexo> listarTodos();
	public Sexo obtenerUno(String id);
	public boolean insertar(Sexo sexo);
	public boolean editar(Sexo sexo);
	public boolean borrar(String id);
}
