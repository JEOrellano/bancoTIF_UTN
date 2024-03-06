package entidad;

public class EstadoPrestamo {
	private int codigoEstadoPrestamo;
	private String descripcion;
	private int estado;
	
	public EstadoPrestamo() {
		
	}

	public EstadoPrestamo(int codigoEstadoPrestamo, String descripcion, int estado) {
		this.codigoEstadoPrestamo = codigoEstadoPrestamo;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCodigoEstadoPrestamo() {
		return codigoEstadoPrestamo;
	}

	public void setCodigoEstadoPrestamo(int codigoEstadoPrestamo) {
		this.codigoEstadoPrestamo = codigoEstadoPrestamo;
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
		return "EstadoPrestamo [codigoEstadoPrestamo=" + codigoEstadoPrestamo + ", descripcion=" + descripcion
				+ ", estado=" + estado + "]";
	}
	
}
