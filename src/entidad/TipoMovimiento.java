package entidad;

public class TipoMovimiento {
	private int codigoTipoMovimiento;
	private String descripcion;
	private int estado;
	
	public TipoMovimiento() {
		
	}

	public TipoMovimiento(int codigoTipoMovimiento, String descripcion, int estado) {
		super();
		this.codigoTipoMovimiento = codigoTipoMovimiento;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCodigoTipoMovimiento() {
		return codigoTipoMovimiento;
	}

	public void setCodigoTipoMovimiento(int codigoTipoMovimiento) {
		this.codigoTipoMovimiento = codigoTipoMovimiento;
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
		return "TipoMovimiento [codigoTipoMovimiento=" + codigoTipoMovimiento + ", descripcion=" + descripcion
				+ ", estado=" + estado + "]";
	}
	
}
