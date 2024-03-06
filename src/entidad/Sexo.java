package entidad;

public class Sexo {
	private String codigoSexo;
	private String descripcion;
	private int Estado;
	
	public Sexo() {
		
	}

	public Sexo(String codigoSexo, String descripcion, int estado) {
		super();
		this.codigoSexo = codigoSexo;
		this.descripcion = descripcion;
		Estado = estado;
	}

	public String getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(String codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Sexo [codigoSexo=" + codigoSexo + ", descripcion=" + descripcion + ", Estado=" + Estado + "]";
	}

}
