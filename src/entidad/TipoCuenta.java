package entidad;

public class TipoCuenta {
	private int codigoTipoCuenta;
	private String descripcion;
	private int estado;
	
	public TipoCuenta() {
		
	}

	public TipoCuenta(int codigoTipoCuenta, String descripcion, int estado) {
		super();
		this.codigoTipoCuenta = codigoTipoCuenta;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCodigoTipoCuenta() {
		return codigoTipoCuenta;
	}

	public void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta = codigoTipoCuenta;
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
		return "TipoCuenta [codigoTipoCuenta=" + codigoTipoCuenta + ", descripcion=" + descripcion + ", estado="
				+ estado + "]";
	}
	
}
