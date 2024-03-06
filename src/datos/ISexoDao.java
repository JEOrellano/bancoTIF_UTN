package datos;

import java.util.List;

import entidad.Sexo;

public interface ISexoDao {
	public List<Sexo> obtenerTodos();
	public Sexo obtenerUno(String id);
	public boolean insertar(Sexo sexo);
	public boolean editar(Sexo sexo);
	public boolean borrar(String id);

}
