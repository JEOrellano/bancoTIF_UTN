package entidad;

public class Rol {
	private int codigoRol;
	private String descripcion;
	private int estado;
	
	public Rol() {
		
	}

	public Rol(int codigoRol, String descripcion, int estado) {
		super();
		this.codigoRol = codigoRol;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(int codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Rol [codigoRol=" + codigoRol + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

	
}
